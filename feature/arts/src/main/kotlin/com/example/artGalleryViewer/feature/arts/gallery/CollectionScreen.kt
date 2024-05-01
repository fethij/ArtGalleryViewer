package com.example.artGalleryViewer.feature.arts.gallery

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.artGalleryViewer.core.model.WebImage
import com.example.artGalleryViewer.feature.arts.R
import com.example.artGalleryViewer.feature.arts.gallery.components.ArtItem
import com.example.artGalleryViewer.feature.arts.gallery.model.ArtsUiState
import com.example.artGalleryViewer.feature.arts.gallery.model.GalleryEvent
import com.example.artGalleyViewer.core.designsystem.component.AgvTopBar
import com.example.artGalleyViewer.core.designsystem.component.AvgFilterChip

@Composable
fun CollectionScreenRoute(
    viewModel: GalleryViewModel,
    onBackClick: () -> Unit,
    onArtClick: (String) -> Unit,
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    CollectionScreen(
        uiState = uiState,
        onBackClick = onBackClick,
        onArtClick = onArtClick,
        onPlaceFiltered = viewModel::onEvent,
        modifier = Modifier.fillMaxSize()
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun CollectionScreen(
    uiState: ArtsUiState,
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    onArtClick: (String) -> Unit,
    onPlaceFiltered: (GalleryEvent) -> Unit
) {
    Scaffold(
        modifier = modifier
            .testTag(stringResource(R.string.arts_screen)),
        topBar = {
            AgvTopBar(
                title = {},
                navigationIcon = {
                    IconButton(
                        onClick = { onBackClick() },
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = null
                        )
                    }
                },
                actions = {
                    IconButton(
                        onClick = { /* TODO */ },
                    ) {
                        Icon(
                            imageVector = Icons.Default.FilterList,
                            contentDescription = null
                        )
                    }
                }
            )
        }
    ) { contentPadding ->
        when (uiState) {
            is ArtsUiState.Success -> {
                Column(
                    modifier = Modifier
                        .padding(contentPadding)
                        .fillMaxSize(),
                ) {
                    LazyRow(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        items(
                            items = uiState.productionPlaces,
                            key = { place -> "key-$place" }
                        ) { place ->

                            AvgFilterChip(
                                modifier = Modifier.padding(horizontal = 4.dp),
                                selected = uiState.filteredPlaces.contains(place),
                                onSelectedChange = {
                                    onPlaceFiltered(
                                        GalleryEvent.PlaceFiltered(
                                            place
                                        )
                                    )
                                },
                                label = {
                                    Text(
                                        text = place,
                                        fontSize = MaterialTheme.typography.labelMedium.fontSize
                                    )
                                },
                            )
                        }
                    }
                    LazyColumn(
                        modifier = Modifier
                            .padding(top = 8.dp),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        items(
                            items = uiState.filteredArts,
                            key = { art -> "key-${art.objectNumber}" }
                        ) { art ->
                            ArtItem(
                                url = art.webImage.url,
                                id = art.objectNumber,
                                title = art.title,
                                onClick = { onArtClick(art.objectNumber) },
                                modifier = modifier.padding(horizontal = 8.dp, vertical = 6.dp)
                            )
                        }
                    }
                }
            }

            is ArtsUiState.Loading,
            is ArtsUiState.Empty -> Unit
        }
    }
}

@Preview
@Composable
fun PreviewCollectionScreen() {
    val success = ArtsUiState.Success(
        listOf(
            com.example.artGalleryViewer.core.model.Art(
                title = "Title",
                webImage = WebImage(
                    url = "https://lh3.googleusercontent.com/SsEIJWka3_cYRXXSE8VD3XNOgtOxoZhqW1uB6UFj78eg8gq3G4jAqL4Z_5KwA12aD7Leqp27F653aBkYkRBkEQyeKxfaZPyDx0O8CzWg=s0",
                    width = 100,
                    height = 100,
                    offsetPercentageX = 0,
                    offsetPercentageY = 0,
                    guid = "1"
                ),
                productionPlaces = emptyList(),
                objectNumber = "1",
                longTitle = "Long Title"
            )
        )
    )
    CollectionScreen(
        uiState = success,
        onBackClick = {},
        onArtClick = {},
        onPlaceFiltered = {}
    )
}