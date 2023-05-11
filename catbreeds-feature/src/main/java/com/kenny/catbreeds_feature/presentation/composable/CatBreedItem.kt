package com.kenny.catbreeds_feature.presentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.kenny.catbreeds_feature.presentation.model.CatBreedDisplayed

@Composable
fun CatBreedItem(
    catBreed: CatBreedDisplayed
) {
        Card(
            elevation = 10.dp,
            modifier = Modifier.padding(10.dp)
        ) {
            Column {
                Text(
                    text = catBreed.breedName,
                    fontSize = 16.sp
                )
                Image(
                    painter = rememberAsyncImagePainter(catBreed.imageUrl),
                    contentDescription = null,
                    modifier = Modifier.width(IntrinsicSize.Min)
                )
                Row() {
                    Text(text = catBreed.country)
                    Text(text = catBreed.intelligent.toString())
                }
            }
        }

}