package com.gmind.edukasihipertensi

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.gmind.edukasihipertensi.databinding.ActivityQuizBinding

class QuizActivity : AppCompatActivity() {

    private lateinit var activityQuizBinding: ActivityQuizBinding

    private var score : Int = 0
    private var currentPosition : Int = 1
    private var soalList : ArrayList<Quiz> ? = null
    private var selectedOption : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityQuizBinding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(activityQuizBinding.root)

        soalList = QuizData.getSoal()

        setSoal()

        activityQuizBinding.tvOpsi1.setOnClickListener {
            selectedOptionStyle(activityQuizBinding.tvOpsi1, 1)
        }

        activityQuizBinding.tvOpsi2.setOnClickListener {
            selectedOptionStyle(activityQuizBinding.tvOpsi2, 2)
        }

        activityQuizBinding.tvOpsi3.setOnClickListener {
            selectedOptionStyle(activityQuizBinding.tvOpsi3, 3)
        }

        activityQuizBinding.tvOpsi4.setOnClickListener {
            selectedOptionStyle(activityQuizBinding.tvOpsi4, 4)
        }

        activityQuizBinding.btnNext.setOnClickListener {
            if (selectedOption != 0){
                val soal = soalList!![currentPosition-1]
                if (selectedOption != soal.jawaban){
                    setColor(selectedOption, R.drawable.wrong_question_option)
                } else{
                    score++
                }
                setColor(soal.jawaban, R.drawable.correct_question_option)
                if (currentPosition == soalList!!.size)
                    activityQuizBinding.btnNext.text = "Selesai"
                else
                    activityQuizBinding.btnNext.text = "Selanjutnya"
            } else{
                currentPosition++
                when{
                    currentPosition <= soalList!!.size ->{
                      setSoal()
                    }
                    else -> {
                      val intent = Intent(this, ResultActivity::class.java)
                      intent.putExtra(QuizData.score, score.toString())
                      intent.putExtra("soal size", soalList!!.size.toString())

                      startActivity(intent)
                      finish()
                    }
                }
            }
            selectedOption = 0
        }
    }

    private fun setColor(opsi: Int, color: Int) {
        when(opsi){
            1 -> {
                activityQuizBinding.tvOpsi1.background = ContextCompat.getDrawable(this, color)
            }

            2 -> {
                activityQuizBinding.tvOpsi2.background = ContextCompat.getDrawable(this, color)
            }

            3 -> {
                activityQuizBinding.tvOpsi3.background = ContextCompat.getDrawable(this, color)
            }

            4 -> {
                activityQuizBinding.tvOpsi4.background = ContextCompat.getDrawable(this, color)
            }
        }
    }

    private fun selectedOptionStyle(view: TextView, opsi: Int) {
        setOptionStyle()
        selectedOption = opsi
        view.background = ContextCompat.getDrawable(this, R.drawable.selected_question_option)
        view.setTextColor(Color.parseColor("#000000"))
    }

    private fun setOptionStyle() {
        val optionList : ArrayList<TextView> = arrayListOf()
        optionList.add(0, activityQuizBinding.tvOpsi1)
        optionList.add(1, activityQuizBinding.tvOpsi2)
        optionList.add(2, activityQuizBinding.tvOpsi3)
        optionList.add(3, activityQuizBinding.tvOpsi4)

        for (i in optionList){
            i.setTextColor(Color.parseColor("#555151"))
            i.background = ContextCompat.getDrawable(this, R.drawable.question_option)
            i.typeface = Typeface.DEFAULT
        }
    }

    private fun setSoal() {
        val soal = soalList!![currentPosition-1]
        setOptionStyle()

        activityQuizBinding.progressBar.progress = currentPosition
        activityQuizBinding.progressBar.max = soalList!!.size

        activityQuizBinding.tvNoSoal.text = "${currentPosition}" + "/" + "${soalList!!.size}"

        activityQuizBinding.tvSoal.text = soal.soal

        activityQuizBinding.tvOpsi1.text = soal.opsi1
        activityQuizBinding.tvOpsi2.text = soal.opsi2
        activityQuizBinding.tvOpsi3.text = soal.opsi3
        activityQuizBinding.tvOpsi4.text = soal.opsi4

    }
}