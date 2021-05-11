package com.example.eggcelent

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.eggcelent.util.TwelveMinutePrefUtil
import com.example.eggcelent.util.TwelveMinuteNotificationUtil

class TwelveMinuteTimerExpiredReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        TwelveMinuteNotificationUtil.showTimerExpired(context)

        TwelveMinutePrefUtil.setTimerState(TwelveMinuteActivity.TimerState.Stopped, context)
        TwelveMinutePrefUtil.setAlarmSetTime(0, context)
    }
}