package com.gmind.edukasihipertensi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gmind.edukasihipertensi.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var activityResultBinding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityResultBinding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(activityResultBinding.root)

        val nilai = intent.getStringExtra(QuizData.score)
        val totalSoal = intent.getStringExtra("soal size")

        activityResultBinding.tvNilai.text = "$nilai / $totalSoal"

        activityResultBinding.btnToHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}