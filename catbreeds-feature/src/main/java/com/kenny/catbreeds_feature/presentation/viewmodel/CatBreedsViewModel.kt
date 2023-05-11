package com.kenny.catbreeds_feature.presentation.viewmodel

import androidx.lifecycle.SavedStateHandle
import com.kenny.catbreeds_feature.domain.usecase.GetCatBreedsUseCase
import com.kenny.catbreeds_feature.presentation.CatBreedsIntent
import com.kenny.catbreeds_feature.presentation.CatBreedsIntent.GetCatBreeds
import com.kenny.catbreeds_feature.presentation.CatBreedsUiState
import com.kenny.catbreeds_feature.presentation.CatBreedsUiState.PartialState
import com.kenny.catbreeds_feature.presentation.CatBreedsUiState.PartialState.Loading
import com.kenny.catbreeds_feature.presentation.CatBreedsUiState.PartialState.Fetched
import com.kenny.catbreeds_feature.presentation.CatBreedsUiState.PartialState.Error
import com.kenny.catbreeds_feature.presentation.mapper.toPresentationModel
import com.kenny.core.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

@HiltViewModel
class CatBreedsViewModel @Inject constructor(
    private val getCatBreedsUseCase: GetCatBreedsUseCase,
    savedStateHandle: SavedStateHandle,
    catBreedsUiState: CatBreedsUiState,
) : BaseViewModel<CatBreedsUiState, PartialState, CatBreedsIntent>(
    savedStateHandle,
    catBreedsUiState
) {
    init {
        acceptIntent(GetCatBreeds)
    }

    override fun mapIntents(intent: CatBreedsIntent): Flow<PartialState> = when (intent) {
        is GetCatBreeds -> getCatBreeds()
    }

    override fun reduceUiState(
        previousState: CatBreedsUiState,
        partialState: PartialState
    ): CatBreedsUiState = when (partialState) {
        is Loading -> previousState.copy(
            isLoading = true,
            isError = false
        )
        is Fetched -> previousState.copy(
            isLoading = false,
            catBreeds = partialState.list,
            isError = false
        )
        is Error -> previousState.copy(
            isLoading = false,
            isError = true
        )
    }

    private fun getCatBreeds(): Flow<PartialState> = flow {
        getCatBreedsUseCase()
            .onStart {
                emit(Loading)
            }
            .collect { result ->
                result
                    .onSuccess { catBreedsList ->
                        emit(Fetched(catBreedsList.map { it.toPresentationModel() }))
                    }
                    .onFailure {
                        emit(Error(it))
                    }
            }
    }
}