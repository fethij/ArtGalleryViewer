package com.example.artGalleryViewer.feature.arts.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.artGalleryViewer.feature.arts.R
import com.example.artGalleryViewer.feature.arts.detail.model.DetailUiState
import com.example.artGalleyViewer.core.designsystem.component.AgvError
import com.example.artGalleyViewer.core.designsystem.component.AgvImage
import com.example.artGalleyViewer.core.designsystem.component.AgvLoading
import com.example.artGalleyViewer.core.designsystem.component.AgvTopBar

@Composable
fun DetailScreenRoute(
    objectId: String,
    viewModel: DetailViewModel,
    onBackClick: () -> Unit,
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    DetailScreen(uiState) {
        onBackClick()
    }

    LaunchedEffect(Unit) {
        viewModel.getDetail(objectId)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    uiState: DetailUiState,
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit
) {
    Scaffold(
        modifier = modifier
            .background(Color.Red)
            .testTag(stringResource(R.string.detail_screen)),
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
            is DetailUiState.Loading -> {
                AgvLoading()
            }

            is DetailUiState.Error -> {
                AgvError(
                    modifier = modifier.fillMaxSize(),
                )
            }

            is DetailUiState.Success -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp, vertical = 16.dp)
                        .padding(contentPadding)
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.spacedBy(36.dp)

                ) {
                    Text(
                        text = uiState.art.title,
                        style = MaterialTheme.typography.headlineLarge,
                        textAlign = TextAlign.Start,
                        fontFamily = FontFamily(Font(R.font.lugrasimo_regular)),
                        modifier = Modifier
                            .padding(bottom = 2.dp)
                    )
                    Row(
                        modifier = modifier,
                        horizontalArrangement = Arrangement.spacedBy(36.dp),
                        verticalAlignment = Alignment.Top
                    ) {
                        Text(
                            text = "--",
                            style = MaterialTheme.typography.headlineLarge,
                            textAlign = TextAlign.Start,
                            modifier = Modifier
                                .padding(bottom = 2.dp)
                        )
                        Text(text = uiState.art.description)
                    }
                    AgvImage(
                        imageUrl = uiState.art.url,
                        modifier = modifier
                            .fillMaxWidth()
                            .height(400.dp)
                            .clip(RoundedCornerShape(16.dp))
                    )
                }
            }
        }
    }
}