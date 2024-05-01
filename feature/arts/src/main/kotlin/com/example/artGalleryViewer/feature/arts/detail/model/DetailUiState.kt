package com.example.artGalleryViewer.feature.arts.detail.model

import com.example.artGalleryViewer.core.model.ArtObject

sealed interface DetailUiState {
    data object Loading : DetailUiState
    data class Success(val art: ArtObject) : DetailUiState
    data object Error : DetailUiState
}