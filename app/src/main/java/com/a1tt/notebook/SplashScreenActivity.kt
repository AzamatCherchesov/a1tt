package com.a1tt.notebook

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.a1tt.notebook.MainApplication.Companion.countDownTimer
import com.a1tt.notebook.MainApplication.Companion.timerCounter
import com.a1tt.notebook.tutorial.TutorialActivity

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)
    }

    override fun onPostResume() {
        super.onPostResume()

        if (countDownTimer != null) {
            countDownTimer!!.cancel()
        }
        countDownTimer = object : CountDownTimer(timerCounter, 10) {
            override fun onTick(millisUntilFinished: Long) {
                timerCounter = millisUntilFinished
            }

            override fun onFinish() {
                onTimer()
            }
        }.start()

        val image = findViewById<View>(R.id.animImage) as ImageView
        val animation = AnimationUtils.loadAnimation(applicationContext,
            R.anim.fadeout)
        image.startAnimation(animation)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (countDownTimer != null) {
            countDownTimer!!.cancel()
            countDownTimer = null
        }
        finish()
    }

    override fun onPause() {
        super.onPause()
        if (countDownTimer != null) {
            countDownTimer!!.cancel()
            countDownTimer = null
        }
    }

    fun onTimer() {
        val intent = Intent(this, TutorialActivity::class.java)
        startActivity(intent)
        finish()
    }
}