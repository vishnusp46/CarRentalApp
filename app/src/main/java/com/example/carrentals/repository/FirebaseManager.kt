package com.example.carrentals.repository

import android.util.Log
import com.example.carrentals.model.RentalSession

class FirebaseManager {
    fun sendOverSpeedAlert(rentalSession: RentalSession, currentSpeed: Float) {
        // Placeholder to send Alert to Firebase server
        Log.d(
            "FirebaseManager",
            "OVER SPEED ALERT: Driving at $currentSpeed km/h, session=$rentalSession"
        )
    }
}
