package com.gmind.listtutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.gmind.listtutorial.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    companion object{
        const val NAMA = "extra_name"
        const val DESKRIPSI = "extra_detail"
        const val PHOTO = "extra_photo"
    }

    private lateinit var activityDetailBinding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDetailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(activityDetailBinding.root)

        val photo = intent.getIntExtra(PHOTO, 0)
        Glide.with(this)
                .load(photo)
                .into(activityDetailBinding.ivGambar)

        val nama = intent.getStringExtra(NAMA)
        activityDetailBinding.tvNama.text = nama

        val deskripsi = intent.getStringExtra(DESKRIPSI)
        activityDetailBinding.tvDeskripsi.text = deskripsi

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setTitle("Detail")
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}