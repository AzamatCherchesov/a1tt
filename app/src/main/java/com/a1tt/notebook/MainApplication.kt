package com.a1tt.notebook

import android.app.Application
import android.graphics.Bitmap
import android.os.CountDownTimer
import com.crashlytics.android.Crashlytics
import com.crashlytics.android.core.CrashlyticsCore
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes
import io.fabric.sdk.android.Fabric

class MainApplication :Application(){
    override fun onCreate() {
        super.onCreate()
        instance = this
        AppCenter.start(this, "bcc4667b-07d3-4cbf-bcf3-a306e5e48f97", Analytics::class.java, Crashes::class.java)
        Analytics.trackEvent("test")
        val crashlytics = Crashlytics.Builder().core(CrashlyticsCore.Builder().disabled(false).build()).build()
        Fabric.with(this, crashlytics)
        Crashlytics.log("test1")
    }

    companion object {
        lateinit var instance: MainApplication
            private set
        var countDownTimer: CountDownTimer? = null
        var timerCounter: Long = 3000
        lateinit var appsIcons: HashMap<String, Bitmap>

    }
}