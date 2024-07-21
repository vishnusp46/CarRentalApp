package com.example.carrentals.view

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.example.carrentals.model.RentalSession
import com.example.carrentals.repository.SpeedMonitorRepository
import com.example.carrentals.util.createForegroundServiceNotification
import com.example.carrentals.util.createSpeedAlertNotification
import com.example.carrentals.util.showNotification

class SpeedMonitorService : Service() {

    private val speedMonitorRepository = SpeedMonitorRepository()
    private var rentalSession: RentalSession? = null
    private var vehicleSpeedManager: VehicleSpeedManager? = null

    private val onSpeedChangeListener = { speed ->
        rentalSession?.maxSpeed?.let { maxSpeed ->
            if (speed > maxSpeed) {
                speedMonitorRepository.sendOverSpeedAlertToServer(rentalSession!!, speed)
                val notification = createSpeedAlertNotification(this, speed, maxSpeed)
                showNotification(this, OVER_SPEED_NOTIFICATION_ID, notification)
            }
        }
    }

    override fun onCreate() {
        super.onCreate()
        rentalSession = speedMonitorRepository.getRentalSession(this)
        if (rentalSession == null) {
            Log.d(TAG, "Stopping service as no active rental session found.")
            stopSelf()
        } else {
            Log.d(TAG, "Started monitoring Speed for rentalSession= $rentalSession")
            monitorSpeed()
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        startForeground(
            FOREGROUND_SERVICE_NOTIFICATION_ID,
            createForegroundServiceNotification(this)
        )
        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onDestroy() {
        super.onDestroy()
        vehicleSpeedManager?.removeOnSpeedChangeListener(onSpeedChangeListener)
        rentalSession = null
    }

    private fun monitorSpeed() {
        // Assumption: There is a vehicle speed system service running in the device and it's
        // APIs are exposed via VehicleSpeedManager class.
        vehicleSpeedManager = getSystemService(Context.VEHICLE_SPEED_SERVICE).apply {
            setOnSpeedChangeListener(onSpeedChangeListener)
        }
    }

    companion object {
        private const val TAG = "SpeedMonitorService"
        private const val FOREGROUND_SERVICE_NOTIFICATION_ID = 100
        private const val OVER_SPEED_NOTIFICATION_ID = 500
    }
}
