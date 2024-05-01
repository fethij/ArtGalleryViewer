package com.example.artGalleryViewer.core.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkWebImage(
    @SerialName("guid") var guid: String,
    @SerialName("offsetPercentageX") var offsetPercentageX: Int,
    @SerialName("offsetPercentageY") var offsetPercentageY: Int,
    @SerialName("width") var width: Int,
    @SerialName("height") var height: Int,
    @SerialName("url") var url: String
)

fun NetworkWebImage.asWebImage() = com.example.artGalleryViewer.core.model.WebImage(
    guid = guid,
    offsetPercentageX = offsetPercentageX,
    offsetPercentageY = offsetPercentageY,
    width = width,
    height = height,
    url = url
)