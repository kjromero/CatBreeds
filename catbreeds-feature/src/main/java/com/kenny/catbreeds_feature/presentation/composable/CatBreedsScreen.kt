package com.kenny.catbreeds_feature.presentation.composable

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.kenny.catbreeds_feature.R
import com.kenny.catbreeds_feature.presentation.CatBreedsUiState
import com.kenny.catbreeds_feature.presentation.viewmodel.CatBreedsViewModel
import com.kenny.core.extensions.collectAsStateWithLifecycle

@Composable
fun CatBreedsRoute(
    viewModel: CatBreedsViewModel = hiltViewModel()
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    CatBreedsScreen(
        uiState = uiState
    )
}

@Composable
fun CatBreedsScreen(
    uiState: CatBreedsUiState
) {
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) {
        Surface (
            modifier = Modifier
                .padding(it)
        ) {
            if (uiState.catBreeds.isNotEmpty()) {
                CatBreedsAvailableContent(
                    snackbarHostState = snackbarHostState,
                    uiState = uiState,
                )
            } else {
                CatBreedsNotAvailableContent(
                    uiState = uiState
                )
            }
        }
    }
}

@Composable
fun CatBreedsAvailableContent(
    snackbarHostState: SnackbarHostState,
    uiState: CatBreedsUiState,
) {
    if (uiState.isError) {
        val errorMessage = stringResource(R.string.error_label)

        LaunchedEffect(snackbarHostState) {
            snackbarHostState.showSnackbar(
                message = errorMessage
            )
        }
    }

    CatBreedsListContent(
        list = uiState.catBreeds,
    )
}

@Composable
private fun CatBreedsNotAvailableContent(uiState: CatBreedsUiState) {
    when {
        uiState.isLoading -> CatBreedsLoadingContent()
        uiState.isError -> CatBreedsErrorContent()
    }
}
