package com.dicoding.mybeginnerandroidsubmission

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Player(
    val name: String,
    val nationality: String,
    val position: String,
    val number: Int,
    val date: String,
    val place: String,
    val height: String,
    val weight: String,
    val desc: String,
    val photo: Int
) : Parcelable


