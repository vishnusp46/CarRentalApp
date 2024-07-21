package com.example.carrentals.util

import android.app.Notification
import android.content.Context
import androidx.core.app.NotificationCompat
import com.example.carrentals.R

private const val CHANNEL_ID = "SpeedMonitorNotificationChannel"

fun createForegroundServiceNotification(context: Context): Notification {
    return NotificationCompat.Builder(context, CHANNEL_ID)
        .setContentTitle("Speed Monitoring Active")
        .setContentText("The speed monitoring service is running.")
        .setSmallIcon(R.drawable.ic_launcher_foreground)
        .setPriority(NotificationCompat.PRIORITY_LOW)
        .build()
}