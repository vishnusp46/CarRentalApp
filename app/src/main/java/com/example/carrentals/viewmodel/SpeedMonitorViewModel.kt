package com.example.carrentals.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.carrentals.model.RentalSession
import com.example.carrentals.repository.SpeedMonitorRepository

class SpeedMonitorViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = SpeedMonitorRepository()

    fun createSession(customerId: String, maxSpeed: Float): RentalSession {
        return RentalSession(customerId, maxSpeed).apply {
            repository.saveRentalSession(getApplication(), this)
        }
    }

    fun startMonitoring(session: RentalSession) {}

    fun stopMonitoring() {}

}