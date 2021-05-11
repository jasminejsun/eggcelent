package com.example.eggcelent

import android.app.Notification
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.eggcelent.util.TwelveMinuteNotificationUtil
import com.example.eggcelent.util.TwelveMinutePrefUtil

class TwelveMinuteTimerNotificationActionReceiver : BroadcastReceiver() {

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onReceive(context: Context, intent: Intent) {
        when (intent.action){
            AppConstants.ACTION_STOP -> {
                TwelveMinuteActivity.removeAlarm(context)
                TwelveMinutePrefUtil.setTimerState(TwelveMinuteActivity.TimerState.Stopped, context)
                TwelveMinuteNotificationUtil.hideTimerNotification(context)
            }
            AppConstants.ACTION_PAUSE -> {
                var secondsRemaining = TwelveMinutePrefUtil.getSecondsRemaining(context)
                val alarmSetTime = TwelveMinutePrefUtil.getAlarmSetTime(context)
                val nowSeconds = TwelveMinuteActivity.nowSeconds

                secondsRemaining -= nowSeconds - alarmSetTime
                TwelveMinutePrefUtil.setSecondsRemaining(secondsRemaining, context)

                TwelveMinuteActivity.removeAlarm(context)
                TwelveMinutePrefUtil.setTimerState(TwelveMinuteActivity.TimerState.Paused, context)
                TwelveMinuteNotificationUtil.showTimerPaused(context)
            }
            AppConstants.ACTION_RESUME -> {
                var secondsRemaining = TwelveMinutePrefUtil.getSecondsRemaining(context)
                var wakeUpTime = TwelveMinuteActivity.setAlarm(context, TwelveMinuteActivity.nowSeconds, secondsRemaining)
                TwelveMinutePrefUtil.setTimerState(TwelveMinuteActivity.TimerState.Running, context)
                TwelveMinuteNotificationUtil.showTimerRunning(context, wakeUpTime)
            }
            AppConstants.ACTION_START -> {
                val minutesRemaining = TwelveMinutePrefUtil.getTimerLength(context)
                val secondsRemaining = minutesRemaining * 60L
                val wakeUpTime = TwelveMinuteActivity.setAlarm(context, TwelveMinuteActivity.nowSeconds, secondsRemaining)
                TwelveMinutePrefUtil.setTimerState(TwelveMinuteActivity.TimerState.Running, context)
                TwelveMinutePrefUtil.setSecondsRemaining(secondsRemaining, context)
                TwelveMinuteNotificationUtil.showTimerRunning(context, wakeUpTime)
            }
        }
    }
}