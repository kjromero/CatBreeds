package com.kenny.catbreeds_feature.data.remote.model

import com.google.gson.annotations.SerializedName

data class CatBreedsResponse(
    @SerializedName("name")
    val breedName: String,
    @SerializedName("origin")
    val country: String,
    @SerializedName("intelligence")
    val intelligent: Int,
    @SerializedName("reference_image_id")
    val imageId: String,
)