package com.example.carrentals.util

import android.app.Notification
import android.app.NotificationManager
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

fun createSpeedAlertNotification(context: Context, currentSpeed: Float, maxSpeed: Float): Notification {
    return NotificationCompat.Builder(context, CHANNEL_ID)
        .setContentTitle("Speed Alert")
        .setContentText("You are driving at $currentSpeed km/h, which exceeds the limit of $maxSpeed km/h")
        .setSmallIcon(R.drawable.ic_launcher_background)
        .setPriority(NotificationCompat.PRIORITY_HIGH)
        .build()
}

fun showNotification(context: Context, notificationId: Int, notification: Notification) {
    val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    notificationManager.notify(notificationId, notification)
}
