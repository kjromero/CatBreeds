package com.kenny.catbreeds_feature.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.kenny.catbreeds_feature.presentation.composable.CatBreedsRoute
import com.kenny.core.ui.CatBreedsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CatBreedsActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CatBreedsTheme {
                CatBreedsRoute()
            }
        }
    }
}