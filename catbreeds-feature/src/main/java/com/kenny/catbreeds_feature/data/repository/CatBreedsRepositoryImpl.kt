package com.kenny.catbreeds_feature.data.repository

import com.kenny.catbreeds_feature.data.mapper.toDomainModel
import com.kenny.catbreeds_feature.data.remote.api.CatBreedsService
import com.kenny.catbreeds_feature.domain.model.CatBreed
import com.kenny.catbreeds_feature.domain.repository.CatBreedsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CatBreedsRepositoryImpl @Inject constructor(
    private val catBreedsService: CatBreedsService,
): CatBreedsRepository {

    override fun getCatBreeds(): Flow<List<CatBreed>> = flow{
        catBreedsService
            .getCatBreeds()
            .map {
                it.toDomainModel()
            }
    }
}