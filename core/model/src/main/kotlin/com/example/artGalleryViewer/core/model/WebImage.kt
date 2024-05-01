package com.example.artGalleryViewer.core.model

data class WebImage(
    val guid: String,
    val offsetPercentageX: Int,
    val offsetPercentageY: Int,
    val width: Int,
    val height: Int,
    val url: String
)