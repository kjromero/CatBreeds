package com.kenny.catbreeds_feature.presentation.composable

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.kenny.catbreeds_feature.domain.model.CatBreed
import com.kenny.catbreeds_feature.presentation.viewmodel.CatBreedsViewModel

@Composable
fun CatBreedsRoute(
    viewModel: CatBreedsViewModel = hiltViewModel()
) {

    val uiState by viewModel.uiState.obse


}