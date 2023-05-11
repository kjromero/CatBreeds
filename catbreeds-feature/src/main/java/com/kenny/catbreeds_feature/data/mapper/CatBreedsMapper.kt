package com.kenny.catbreeds_feature.data.mapper

import com.kenny.catbreeds_feature.data.remote.model.CatBreedsResponse
import com.kenny.catbreeds_feature.domain.model.CatBreed

fun CatBreedsResponse.toDomainModel() = CatBreed(
    breedName = breedName,
    country = country,
    intelligent = intelligent,
    imageUrl = "https://api.thecatapi.com/v1/images/${imageId}.jpg"
)