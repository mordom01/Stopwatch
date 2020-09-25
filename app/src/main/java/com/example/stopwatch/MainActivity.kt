package com.example.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private var elapsedtime = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        chronometer_main_timer.visibility = View.INVISIBLE

        button_main_start.setOnClickListener {
            chronometer_main_timer.base = SystemClock.elapsedRealtime() + elapsedtime
            chronometer_main_timer.visibility = View.VISIBLE
            chronometer_main_timer.start()
        }

        button_main_pause.setOnClickListener {
            elapsedtime = chronometer_main_timer.getBase() - SystemClock.elapsedRealtime()
            chronometer_main_timer.stop()
        }

        button_main_reset.setOnClickListener {
            chronometer_main_timer.base = SystemClock.elapsedRealtime()
            elapsedtime = 0
        }
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause has been called.")
    }
}