package com.alvee.cricvee_jetpack

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp



class CricVee : Application(){
    private val TAG = "CricVee"
    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate: Value ashse")
    }

}
