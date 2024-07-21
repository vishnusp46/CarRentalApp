package com.example.carrentals

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.content.ContextCompat
import com.example.carrentals.view.SpeedMonitorService

class BootCompleteReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Intent.ACTION_BOOT_COMPLETED) {
            Log.d(TAG, "Boot completed detected, starting service")
            val serviceIntent = Intent(context, SpeedMonitorService::class.java)
            ContextCompat.startForegroundService(context, serviceIntent)
        }
    }

    companion object {
        private const val TAG = "BootCompletedReceiver"
    }
}
