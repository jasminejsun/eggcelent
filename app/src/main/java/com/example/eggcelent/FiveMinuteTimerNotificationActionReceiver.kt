package com.example.eggcelent

import android.app.Notification
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.eggcelent.util.FiveMinuteNotificationUtil
import com.example.eggcelent.util.FiveMinutePrefUtil

class FiveMinuteTimerNotificationActionReceiver : BroadcastReceiver() {

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onReceive(context: Context, intent: Intent) {
        when (intent.action){
            AppConstants.ACTION_STOP -> {
                FiveMinuteActivity.removeAlarm(context)
                FiveMinutePrefUtil.setTimerState(FiveMinuteActivity.TimerState.Stopped, context)
                FiveMinuteNotificationUtil.hideTimerNotification(context)
            }
            AppConstants.ACTION_PAUSE -> {
                var secondsRemaining = FiveMinutePrefUtil.getSecondsRemaining(context)
                val alarmSetTime = FiveMinutePrefUtil.getAlarmSetTime(context)
                val nowSeconds = FiveMinuteActivity.nowSeconds

                secondsRemaining -= nowSeconds - alarmSetTime
                FiveMinutePrefUtil.setSecondsRemaining(secondsRemaining, context)

                FiveMinuteActivity.removeAlarm(context)
                FiveMinutePrefUtil.setTimerState(FiveMinuteActivity.TimerState.Paused, context)
                FiveMinuteNotificationUtil.showTimerPaused(context)
            }
            AppConstants.ACTION_RESUME -> {
                var secondsRemaining = FiveMinutePrefUtil.getSecondsRemaining(context)
                var wakeUpTime = FiveMinuteActivity.setAlarm(context, FiveMinuteActivity.nowSeconds, secondsRemaining)
                FiveMinutePrefUtil.setTimerState(FiveMinuteActivity.TimerState.Running, context)
                FiveMinuteNotificationUtil.showTimerRunning(context, wakeUpTime)
            }
            AppConstants.ACTION_START -> {
                val minutesRemaining = FiveMinutePrefUtil.getTimerLength(context)
                val secondsRemaining = minutesRemaining * 60L
                val wakeUpTime = FiveMinuteActivity.setAlarm(context, FiveMinuteActivity.nowSeconds, secondsRemaining)
                FiveMinutePrefUtil.setTimerState(FiveMinuteActivity.TimerState.Running, context)
                FiveMinutePrefUtil.setSecondsRemaining(secondsRemaining, context)
                FiveMinuteNotificationUtil.showTimerRunning(context, wakeUpTime)
            }
        }
    }
}