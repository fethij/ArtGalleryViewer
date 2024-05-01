package com.example.artGalleryViewer.feature.arts.gallery.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.artGalleryViewer.core.model.Art
import com.example.artGalleryViewer.feature.arts.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImageDescription(
    art: Art,
    pagerState: PagerState,
    modifier: Modifier,
    onNavigateToCollection: () -> Unit = {}
) {
    Column(
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.Start,
        modifier = modifier
    ) {
        Text(
            text = art.title,
            style = MaterialTheme.typography.headlineLarge,
            textAlign = TextAlign.Start,
            color = Color.White,
            modifier = Modifier
                .padding(bottom = 2.dp)
        )

        Text(
            text = art.longTitle,
            color = Color.White,
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Start
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedButton(
                modifier = Modifier
                    .height(50.dp)
                    .width(140.dp),
                shape = RoundedCornerShape(20),
                border = BorderStroke(
                    width = 2.dp,
                    color = Color.White,
                ),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color.White,

                    ),
                onClick = { onNavigateToCollection() }
            ) {
                Text(
                    text = stringResource(R.string.collection),
                )
            }

            AgvPager(pagerState = pagerState)
        }
    }
}