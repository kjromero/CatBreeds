package com.kenny.catbreeds_feature.presentation.di

import com.kenny.catbreeds_feature.presentation.CatBreedsUiState
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object CatBreedsPresentationModule {

    @Provides
    fun provideInitialRocketsUiState(): CatBreedsUiState = CatBreedsUiState()
}