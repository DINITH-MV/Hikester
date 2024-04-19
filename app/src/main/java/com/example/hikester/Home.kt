package com.example.hikester

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.annotation.RequiresApi
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.google.android.material.bottomnavigation.BottomNavigationView


class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_naviagtion)

        val homeFragment = homeFragment()
        val notificationFragment = navigationFragment()
        val weatherFragment = weatherFragment()
        val profileFragment = profileFragment()

        supportFragmentManager.beginTransaction().replace(R.id.container1, homeFragment).commit()

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {

                R.id.navigation_home -> {
                    supportFragmentManager.beginTransaction().replace(R.id.container1, homeFragment).commit()
                    true
                }

                R.id.navigation_nav -> {
                    supportFragmentManager.beginTransaction().replace(R.id.container1, notificationFragment).commit()
                    true
                }
                R.id.navigation_weather -> {
                    supportFragmentManager.beginTransaction().replace(R.id.container1, weatherFragment).commit()
                    true
                }
                R.id.navigation_profile -> {
                    supportFragmentManager.beginTransaction().replace(R.id.container1, profileFragment).commit()
                    true
                }
                // Handle other cases
                else -> false
            }
        }




        hideSystemUI()
    }
    @RequiresApi(Build.VERSION_CODES.R)
    private fun hideSystemUI() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        WindowInsetsControllerCompat(window,
            window.decorView.findViewById(android.R.id.content)).let { controller ->
            controller.hide(WindowInsetsCompat.Type.systemBars())

            // When the screen is swiped up at the bottom
            // of the application, the navigationBar shall
            // appear for some time
            controller.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
    }



}