package com.example.carrentals.repository

import android.content.Context
import com.example.carrentals.model.RentalSession

class SpeedMonitorRepository {

    private fun getSharedPreferences(context: Context) =
        context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)

    fun saveRentalSession(context: Context, rentalSession: RentalSession) {
        rentalSession.apply {
            getSharedPreferences(context)
                .edit()
                .putString(PREF_KEY_CUSTOMER_ID, customerId)
                .putFloat(PREF_KEY_MAX_SPEED, maxSpeed)
                .apply()
        }
    }

    fun getRentalSession(context: Context): RentalSession? =
        getSharedPreferences(context).let {
            val customerId = it.getString(PREF_KEY_CUSTOMER_ID, "") ?: return null
            RentalSession(customerId, it.getFloat(PREF_KEY_MAX_SPEED, 0F))
        }

    companion object {
        private const val PREFERENCE_NAME = "com.example.carrentals.CAR_RENTAL_APP_PREF"
        private const val PREF_KEY_CUSTOMER_ID = "customer_id"
        private const val PREF_KEY_MAX_SPEED = "max_speed"
    }
}
