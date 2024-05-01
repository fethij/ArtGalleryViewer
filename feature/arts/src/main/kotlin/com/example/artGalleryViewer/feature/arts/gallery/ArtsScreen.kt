package com.example.artGalleryViewer.feature.arts.gallery

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
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
import com.example.artGalleryViewer.feature.arts.gallery.components.ImageDescription
import com.example.artGalleryViewer.feature.arts.gallery.model.ArtsUiState
import com.example.artGalleyViewer.core.designsystem.component.AgvImage
import com.example.artGalleyViewer.core.designsystem.component.AgvLoading
import kotlin.random.Random

@Composable
fun ArtsScreenRoute(
    viewModel: GalleryViewModel,
    onNavigateToCollection: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    ArtsScreen(
        uiState = uiState,
        onNavigateToCollection = onNavigateToCollection
    )

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun ArtsScreen(
    uiState: ArtsUiState,
    modifier: Modifier = Modifier,
    onNavigateToCollection: () -> Unit
) {
    Scaffold(
        modifier = Modifier
            .testTag(stringResource(R.string.arts_screen)),
    ) { contentPadding ->
        when (uiState) {
            is ArtsUiState.Loading -> {
                AgvLoading(
                    modifier = Modifier
                        .testTag(stringResource(R.string.arts_loading))
                )
            }

            is ArtsUiState.Empty -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center,
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            text = stringResource(R.string.no_arts),
                            style = MaterialTheme.typography.titleLarge
                        )
                    }
                }
            }

            is ArtsUiState.Success -> {
                val initPage: Int = Random.nextInt(0, uiState.arts.size - 4)
                val pagerState = rememberPagerState(
                    pageCount = { uiState.arts.size },
                    initialPage = initPage,
                )
                val currentPage = pagerState.currentPage

                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center,
                ) {
                    HorizontalPager(
                        state = pagerState,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        AgvImage(
                            imageUrl = uiState.arts[it].webImage.url,
                            id = uiState.arts[it].objectNumber,
                            modifier = Modifier.fillMaxSize()
                        )
                    }

                    ImageDescription(
                        art = uiState.arts[currentPage],
                        pagerState = pagerState,
                        onNavigateToCollection = onNavigateToCollection,
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .padding(horizontal = 20.dp)
                            .padding(bottom = 60.dp)
                            .navigationBarsPadding()
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewArtsScreen() {
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
    ArtsScreen(
        uiState = success,
        onNavigateToCollection = {}
    )
}