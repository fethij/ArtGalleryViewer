package com.example.artGalleryViewer.core.network.retrofit

import com.example.artGalleryViewer.core.network.AgwNetworkDataSource
import com.example.artGalleryViewer.core.network.model.NetworkArt
import com.example.artGalleryViewer.core.network.model.NetworkArtObject
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

/**
 * [Retrofit] backed [AgwNetworkDataSource]
 */
@Singleton
class RetrofitAGWNetwork @Inject constructor(
    private val rijksmuseumNetworkApi: RijksmuseumNetworkApi
) : AgwNetworkDataSource {

    override suspend fun getCollection(page: Int): List<NetworkArt> =
        rijksmuseumNetworkApi.getCollection(page = page).networkArtObjects


    override suspend fun getDetail(objectId: String): NetworkArtObject =
        rijksmuseumNetworkApi.getDetail(objectId).networkArtObject
}
