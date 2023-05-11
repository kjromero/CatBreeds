package com.kenny.catbreeds_feature.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CatBreedDisplayed(
    val breedName: String,
    val country: String,
    val intelligent: Int,
    val imageUrl: String,
): Parcelable
