package com.gmind.edukasihipertensi

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hipertensi (
    var judul : String = "",
    var desktripsi : String = "",
    var foto : Int = 0
) : Parcelable