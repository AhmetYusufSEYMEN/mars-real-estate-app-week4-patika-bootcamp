package com.seymen.retrofitandrecyclerview.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MarsModel (
    val id: String,
    val img_src: String,
    val price: String,
    val type: String
) : Parcelable