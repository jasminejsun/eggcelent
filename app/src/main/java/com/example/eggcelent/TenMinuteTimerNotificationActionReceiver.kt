package com.example.eggcelent

import android.app.Notification
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.eggcelent.util.TenMinuteNotificationUtil
import com.example.eggcelent.util.TenMinutePrefUtil

class TenMinuteTimerNotificationActionReceiver : BroadcastReceiver() {

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onReceive(context: Context, intent: Intent) {
        when (intent.action){
            AppConstants.ACTION_STOP -> {
                TenMinuteActivity.removeAlarm(context)
                TenMinutePrefUtil.setTimerState(TenMinuteActivity.TimerState.Stopped, context)
                TenMinuteNotificationUtil.hideTimerNotification(context)
            }
            AppConstants.ACTION_PAUSE -> {
                var secondsRemaining = TenMinutePrefUtil.getSecondsRemaining(context)
                val alarmSetTime = TenMinutePrefUtil.getAlarmSetTime(context)
                val nowSeconds = TenMinuteActivity.nowSeconds

                secondsRemaining -= nowSeconds - alarmSetTime
                TenMinutePrefUtil.setSecondsRemaining(secondsRemaining, context)

                TenMinuteActivity.removeAlarm(context)
                TenMinutePrefUtil.setTimerState(TenMinuteActivity.TimerState.Paused, context)
                TenMinuteNotificationUtil.showTimerPaused(context)
            }
            AppConstants.ACTION_RESUME -> {
                var secondsRemaining = TenMinutePrefUtil.getSecondsRemaining(context)
                var wakeUpTime = TenMinuteActivity.setAlarm(context, TenMinuteActivity.nowSeconds, secondsRemaining)
                TenMinutePrefUtil.setTimerState(TenMinuteActivity.TimerState.Running, context)
                TenMinuteNotificationUtil.showTimerRunning(context, wakeUpTime)
            }
            AppConstants.ACTION_START -> {
                val minutesRemaining = TenMinutePrefUtil.getTimerLength(context)
                val secondsRemaining = minutesRemaining * 60L
                val wakeUpTime = TenMinuteActivity.setAlarm(context, TenMinuteActivity.nowSeconds, secondsRemaining)
                TenMinutePrefUtil.setTimerState(TenMinuteActivity.TimerState.Running, context)
                TenMinutePrefUtil.setSecondsRemaining(secondsRemaining, context)
                TenMinuteNotificationUtil.showTimerRunning(context, wakeUpTime)
            }
        }
    }
}