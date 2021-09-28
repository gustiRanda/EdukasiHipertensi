package com.gmind.edukasihipertensi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.gmind.edukasihipertensi.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_HIPERTENSI = "extra_hipertensi"
    }

    private lateinit var activityDetailBinding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDetailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(activityDetailBinding.root)

        val hipertensi = intent.getParcelableExtra<Hipertensi>(EXTRA_HIPERTENSI)

        Glide.with(this)
                .load(hipertensi?.contentAsset)
                .into(activityDetailBinding.ivDetailFoto)

        activityDetailBinding.tvDetailJudul.text = hipertensi?.contentJudul

        activityDetailBinding.tvDetailContent.text = hipertensi?.contentDeskripsi

        activityDetailBinding.tvBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finishAffinity()
        }
    }
}