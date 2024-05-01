package com.example.artGalleryViewer.core.network

import com.example.artGalleryViewer.core.network.model.NetworkArt
import com.example.artGalleryViewer.core.network.model.NetworkArtObject

/**
 * Interface representing network calls to Rijksmuseum API
 */
interface AgwNetworkDataSource {
    suspend fun getCollection(page: Int): List<NetworkArt>

    suspend fun getDetail(objectId: String): NetworkArtObject
}
