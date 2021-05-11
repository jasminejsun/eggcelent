package com.example.eggcelent

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.eggcelent.util.TenMinutePrefUtil
import com.example.eggcelent.util.TenMinuteNotificationUtil

class TenMinuteTimerExpiredReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        TenMinuteNotificationUtil.showTimerExpired(context)

        TenMinutePrefUtil.setTimerState(TenMinuteActivity.TimerState.Stopped, context)
        TenMinutePrefUtil.setAlarmSetTime(0, context)
    }
}