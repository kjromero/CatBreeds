package com.kenny.catbreeds_feature.domain.usecase

import com.kenny.catbreeds_feature.domain.model.CatBreed
import com.kenny.catbreeds_feature.domain.repository.CatBreedsRepository
import com.kenny.core.extensions.resultOf
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.retryWhen
import java.io.IOException

private const val RETRY_TIME_IN_MILLIS = 15_000L

fun interface GetCatBreedsUseCase : () -> Flow<Result<List<CatBreed>>>

fun getCatBreeds(
    catBreedsRepository: CatBreedsRepository
): Flow<Result<List<CatBreed>>> = catBreedsRepository
    .getCatBreeds()
    .map {
        resultOf { it }
    }
    .retryWhen { cause, _ ->
        if (cause is IOException) {
            emit(Result.failure(cause))

            delay(RETRY_TIME_IN_MILLIS)
            true
        } else {
            false
        }
    }
    .catch {
        emit(Result.failure(it))
    }
