package com.kenny.catbreeds_feature.presentation.mapper

import com.kenny.catbreeds_feature.domain.model.CatBreed
import com.kenny.catbreeds_feature.presentation.model.CatBreedDisplayed

fun CatBreed.toPresentationModel() = CatBreedDisplayed(
    breedName = breedName,
    country = country,
    imageUrl = imageUrl,
    intelligent = intelligent,
)