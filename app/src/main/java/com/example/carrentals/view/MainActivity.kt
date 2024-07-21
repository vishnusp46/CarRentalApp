package com.example.carrentals.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.carrentals.R
import com.example.carrentals.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

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
        // another to stop the session. [Invoked stopRentalSession() wen clicked]
    }

    private fun startRentalSession() {
        // Validate the inputs from the edit texts

    }

    private fun stopRentalSession() {
        // Clear the edit texts and make them visible.
        // Hide the stop session button
        // Clear Session data.
    }
}
