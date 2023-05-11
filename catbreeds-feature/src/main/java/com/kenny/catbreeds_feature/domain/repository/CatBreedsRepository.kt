package com.kenny.catbreeds_feature.domain.repository

import com.kenny.catbreeds_feature.domain.model.CatBreed
import kotlinx.coroutines.flow.Flow

interface CatBreedsRepository {
    fun getCatBreeds() : Flow<List<CatBreed>>
}