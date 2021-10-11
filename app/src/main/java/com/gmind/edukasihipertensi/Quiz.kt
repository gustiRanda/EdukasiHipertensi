package com.gmind.edukasihipertensi

data class Quiz (
        var id:  Int = 0,
        var soal : String = "",

        var opsi1 : String = "",
        var opsi2 : String = "",
        var opsi3 : String = "",
        var opsi4 : String = "",
        var jawaban : Int = 0

)