package com.example.carrentals.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.carrentals.R
import com.example.carrentals.databinding.ActivityMainBinding
import com.example.carrentals.viewmodel.SpeedMonitorViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val speedMonitorViewModel: SpeedMonitorViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        setupViews()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setupViews() {
        // UI is supposed to have 2 edit texts to enter customer id and max speed.
        // 2 buttons -
        // One to start rental session, [Invokes startRentalSession() when clicked]
        // another to stop the session. [Invoked stopRentalSession() wen clicked], hidden by default.
    }

    private fun startRentalSession() {
        // Validate the inputs from the edit texts
        val customerId = "ABC1244" // Get from the edit text
        val maxSpeed = 80F // Get from edit text
        speedMonitorViewModel.apply {
            createSession(customerId, maxSpeed)
            startMonitoring()
        }
        // Hide the edit texts and start button.
        // Show stop button
    }

    private fun stopRentalSession() {
        // Validate with an OTP to ensure it's stopped by authorised person
        // then Clear the edit texts and make them visible.
        // Hide the stop session button
        speedMonitorViewModel.stopMonitoring()
    }
}
