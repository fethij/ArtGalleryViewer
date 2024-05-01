package com.example.artGalleryViewer.core.network.retrofit

import com.example.artGalleryViewer.core.network.model.CollectionNetworkResponse
import com.example.artGalleryViewer.core.network.model.DetailNetworkResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private const val PAGING_PAGE_SIZE = 100
const val RIJKSMUSEUM_BASE_URL = "https://www.rijksmuseum.nl/api/en/"

/**
 * Retrofit API declaration for Rijksmuseum Network API
 */
interface RijksmuseumNetworkApi {
    @GET("collection")
    suspend fun getCollection(
        @Query("imgonly") imageOnly: Boolean = true,
        @Query("page") page: Int = 1,
        @Query("ps") perPage: Int = PAGING_PAGE_SIZE
    ): CollectionNetworkResponse

    @GET("collection/{objectNumber}")
    suspend fun getDetail(
        @Path(value = "objectNumber") objectNumber: String
    ): DetailNetworkResponse
}