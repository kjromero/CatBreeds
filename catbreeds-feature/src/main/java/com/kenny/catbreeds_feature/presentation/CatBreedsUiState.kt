package com.kenny.catbreeds_feature.presentation

import android.os.Parcelable
import com.kenny.catbreeds_feature.domain.model.CatBreed
import kotlinx.parcelize.Parcelize
import com.kenny.catbreeds_feature.presentation.model.CatBreedDisplayed
import androidx.compose.runtime.Immutable

@Immutable
@Parcelize
data class CatBreedsUiState(
    val isLoading: Boolean = false,
    val catBreeds: List<CatBreedDisplayed> = emptyList(),
    val isError: Boolean = false
): Parcelable {
    sealed class PartialState {
        object Loading : PartialState()

        data class Fetched(val list: List<CatBreedDisplayed>) : PartialState()

        data class Error(val throwable: Throwable) : PartialState()
    }
}