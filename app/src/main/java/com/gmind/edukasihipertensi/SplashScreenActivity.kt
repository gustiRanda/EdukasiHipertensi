package com.gmind.edukasihipertensi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.gmind.edukasihipertensi.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var activitySplashScreenBinding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activitySplashScreenBinding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(activitySplashScreenBinding.root)

        val handler = Handler()
        handler.postDelayed({
            val intent = Intent(this@SplashScreenActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}