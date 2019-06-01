package com.a1tt.a1tt

import android.app.Application
import android.graphics.Bitmap
import android.os.CountDownTimer
import java.util.concurrent.Executors

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