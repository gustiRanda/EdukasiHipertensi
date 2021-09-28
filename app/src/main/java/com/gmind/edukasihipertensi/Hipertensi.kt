package com.gmind.edukasihipertensi

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hipertensi (
    var contentJudul : String = "",
    var contentDeskripsi : String = "",
    var contentIcon : Int = 0,
    var contentAsset : Int = 0
) : Parcelable