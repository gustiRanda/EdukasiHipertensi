package com.gmind.edukasihipertensi

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.gmind.edukasihipertensi.databinding.ActivityDetailVideoBinding

class DetailVideoActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_HIPERTENSI = "extra_hipertensi"
    }

    private lateinit var activityDetailVideoBinding: ActivityDetailVideoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDetailVideoBinding = ActivityDetailVideoBinding.inflate(layoutInflater)
        setContentView(activityDetailVideoBinding.root)

        val hipertensi = intent.getParcelableExtra<Hipertensi>(EXTRA_HIPERTENSI)

        val videoPath = "android.resource://" + packageName + "/" + hipertensi?.contentAsset
        val videoPath2 = "https://media.geeksforgeeks.org/wp-content/uploads/20201217163353/Screenrecorder-2020-12-17-16-32-03-350.mp4"
        val uri = Uri.parse(videoPath)
        val videoView = activityDetailVideoBinding.exoPlayerView

        videoView.setSource(uri.toString())

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()
    }
}