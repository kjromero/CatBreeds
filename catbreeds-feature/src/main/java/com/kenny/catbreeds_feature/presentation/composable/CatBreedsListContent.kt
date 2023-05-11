package com.kenny.catbreeds_feature.presentation.composable

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.dimensionResource
import com.kenny.catbreeds_feature.R
import com.kenny.catbreeds_feature.presentation.model.CatBreedDisplayed

const val CAT_BREED_DIVIDER_TEST_TAG = "catBreedDividerTag"


@Composable
fun CatBreedsListContent(
    list: List<CatBreedDisplayed>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .padding(
                horizontal = dimensionResource(id = R.dimen.dimen_medium)
            )
    ) {
        itemsIndexed(
            items = list,
        ) { index, item ->
            CatBreedItem(
                catBreed = item,
            )

            if (index < list.lastIndex) {
                Divider(
                    modifier = Modifier.testTag(CAT_BREED_DIVIDER_TEST_TAG)
                )
            }
        }
    }
}