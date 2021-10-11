package com.gmind.edukasihipertensi

object QuizData {

    const val score : String = "score"

    fun getSoal() : ArrayList<Quiz>{
        var soal : ArrayList<Quiz> = arrayListOf()

        var soal1 = Quiz(
                1,
                "what is capital of India ?",

                "Uttar Pradesh",
                "Madhya Pradesh",
                "Kanpur",
                "New Delhi",
                4
        )
        var soal2 = Quiz(
                2,
                "Who was the first Indian woman in Space ?",

                "Kalpana Chawla",
                "Sunita Williams",
                "Koneru Humpy",
                "None of the above",
                1
        )
        var soal3 = Quiz(
                3,
                "Who wrote the Indian National Anthem ?",

                "Bakim Chandra Chatterji",
                "Rabindranath Tagore",
                "Swami Vivekanand",
                "None of the above",
                2
        )
        var soal4 = Quiz(
                4,
                "Who was the first President of India ?",

                "Abdul Kalam",
                "Lal Bahadur Shastri",
                "Dr. Rajendra Prasad",
                "Zakir Hussain",
                3
        )

        var soal5 = Quiz(
                5,
                "Who built the Jama Masjid ?",

                "Jahangir",
                "Akbar",
                "Imam Bukhari",
                "Shah Jahan",
                4
        )

        soal.add(soal1)
        soal.add(soal2)
        soal.add(soal3)
        soal.add(soal4)
        soal.add(soal5)
        return soal
    }
}