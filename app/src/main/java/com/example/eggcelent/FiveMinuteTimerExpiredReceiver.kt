package com.example.eggcelent

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.eggcelent.util.FiveMinuteNotificationUtil
import com.example.eggcelent.util.FiveMinutePrefUtil

class FiveMinuteTimerExpiredReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        FiveMinuteNotificationUtil.showTimerExpired(context)

        FiveMinutePrefUtil.setTimerState(FiveMinuteActivity.TimerState.Stopped, context)
        FiveMinutePrefUtil.setAlarmSetTime(0, context)
    }
}