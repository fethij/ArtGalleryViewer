package com.example.artGalleryViewer.feature.arts.gallery.model

import com.example.artGalleryViewer.core.model.Art

sealed interface ArtsUiState {
    data object Empty : ArtsUiState
    data object Loading : ArtsUiState
    data class Success(
        val arts: List<Art>,
        val filteredPlaces: List<String> = emptyList()
    ) : ArtsUiState {
        val productionPlaces: List<String> = arts.flatMap { it.productionPlaces }.distinct()
        val filteredArts: List<Art> = arts.filter { art ->
            filteredPlaces.isEmpty() || art.productionPlaces.any { filteredPlaces.contains(it) }
        }
    }
}