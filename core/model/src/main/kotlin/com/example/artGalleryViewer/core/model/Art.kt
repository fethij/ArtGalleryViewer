package com.example.artGalleryViewer.core.model

data class Art(
    val objectNumber: String,
    val title: String,
    val longTitle: String,
    val webImage: WebImage,
    val productionPlaces: List<String>
)