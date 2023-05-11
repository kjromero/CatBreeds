package com.kenny.catbreeds_feature.data.remote.api

import com.kenny.catbreeds_feature.data.remote.model.CatBreedsResponse
import retrofit2.http.GET

interface CatBreedsApi {

    @GET("breeds")
    suspend fun getCatBreeds(): List<CatBreedsResponse>
}