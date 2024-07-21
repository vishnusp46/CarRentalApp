package com.example.carrentals.viewmodel

import android.app.Application
import android.content.Intent
import androidx.core.content.ContextCompat
import androidx.lifecycle.AndroidViewModel
import com.example.carrentals.model.RentalSession
import com.example.carrentals.repository.SpeedMonitorRepository
import com.example.carrentals.view.SpeedMonitorService

class SpeedMonitorViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = SpeedMonitorRepository()

    fun createSession(customerId: String, maxSpeed: Float): RentalSession {
        return RentalSession(customerId, maxSpeed).apply {
            repository.saveRentalSession(getApplication(), this)
        }
    }

    fun startMonitoring() {
        getApplication<Application>().apply {
            ContextCompat.startForegroundService(
                this,
                Intent(this, SpeedMonitorService::class.java)
            )
        }
    }

    fun stopMonitoring() {
        getApplication<Application>().apply {
            stopService(
                Intent(this, SpeedMonitorService::class.java)
            )
        }
        repository.clearRentalSession(getApplication())
    }

}