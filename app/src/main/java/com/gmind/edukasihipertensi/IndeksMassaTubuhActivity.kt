package com.gmind.edukasihipertensi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.gmind.edukasihipertensi.databinding.ActivityIndeksMassaTubuhBinding

class IndeksMassaTubuhActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var activityIndeksMassaTubuhBinding: ActivityIndeksMassaTubuhBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityIndeksMassaTubuhBinding = ActivityIndeksMassaTubuhBinding.inflate(layoutInflater)
        setContentView(activityIndeksMassaTubuhBinding.root)



        activityIndeksMassaTubuhBinding.btnIndeksCekStatus.setOnClickListener(this)

        activityIndeksMassaTubuhBinding.tvBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finishAffinity()
        }

        }

    override fun onClick(p0: View) {
        if (p0.id == activityIndeksMassaTubuhBinding.btnIndeksCekStatus.id){

            val beratBadan = activityIndeksMassaTubuhBinding.etIndeksBeratBadan.text.toString().trim()
            val tinggiBadan = activityIndeksMassaTubuhBinding.etIndeksTinggiBadan.text.toString().trim()

            var emptyFields = false

            if (beratBadan.isEmpty()){
                emptyFields = true
                activityIndeksMassaTubuhBinding.etIndeksBeratBadan.error = "Silahkan Isi Berat Badan"
                activityIndeksMassaTubuhBinding.etIndeksBeratBadan.requestFocus()
            }

            if (tinggiBadan.isEmpty()){
                emptyFields = true
                activityIndeksMassaTubuhBinding.etIndeksTinggiBadan.error = "Silahkan Isi Tinggi Badan"
                activityIndeksMassaTubuhBinding.etIndeksTinggiBadan.requestFocus()
            }

            if (!emptyFields){
                val tinggiBadanMeter = tinggiBadan.toDouble().div(100)
                val indeksMassaTubuh = beratBadan.toDouble() / (tinggiBadanMeter * tinggiBadanMeter)
                when {
                    indeksMassaTubuh < 18.5 -> {
                        activityIndeksMassaTubuhBinding.tvIndeksStatus.text = "Kurus"
                    }
                    indeksMassaTubuh <= 22.9 -> {
                        activityIndeksMassaTubuhBinding.tvIndeksStatus.text = "Normal"
                    }
                    indeksMassaTubuh <= 24.9 -> {
                        activityIndeksMassaTubuhBinding.tvIndeksStatus.text = " Overweight"
                    }
                    indeksMassaTubuh <= 29.9 -> {
                        activityIndeksMassaTubuhBinding.tvIndeksStatus.text = "Obesitas I"
                    }
                    else -> activityIndeksMassaTubuhBinding.tvIndeksStatus.text = "Obesitas II"
                }
            }
        }

    }


}
