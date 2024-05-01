package com.example.artGalleryViewer.core.model

data class ArtObject(
    var objectNumber: String,
    var title: String,
    var description: String,
    var url: String,
    var webImage: WebImage,
)