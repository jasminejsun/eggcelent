package com.example.eggcelent

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.eggcelent.util.FiveMinutePrefUtil
import com.example.eggcelent.util.NotificationUtil

class FiveMinuteTimerExpiredReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        NotificationUtil.showTimerExpired(context)

        FiveMinutePrefUtil.setTimerState(FiveMinuteActivity.TimerState.Stopped, context)
        FiveMinutePrefUtil.setAlarmSetTime(0, context)
    }
}