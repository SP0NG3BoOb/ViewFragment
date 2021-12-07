package com.example.fakebook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class LoggedIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logged_in)

        val navView = findViewById<BottomNavigationView>(R.id.BottomNavView)

        val controller = findNavController(R.id.nav_host_fragment)

        val appConfig = AppBarConfiguration(setOf(
            R.id.homeFragment,
            R.id.profileFragment,
            R.id.settingsFragment
        ))

        setupActionBarWithNavController(controller, appConfig)
        navView.setupWithNavController(controller)
    }
}