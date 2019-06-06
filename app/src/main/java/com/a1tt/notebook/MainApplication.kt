package com.a1tt.notebook

import android.app.Application
import android.graphics.Bitmap
import android.os.CountDownTimer

class MainApplication :Application(){
    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: MainApplication
            private set
        var countDownTimer: CountDownTimer? = null
        var timerCounter: Long = 3000
        lateinit var appsIcons: HashMap<String, Bitmap>

    }
}