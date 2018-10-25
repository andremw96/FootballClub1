package com.example.wijaya_pc.footballclub.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Club(val name: String?, val image: Int?, val detailClub : String?) : Parcelable