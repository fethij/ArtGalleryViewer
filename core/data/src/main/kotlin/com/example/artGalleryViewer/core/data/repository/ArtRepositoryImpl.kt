package com.example.artGalleryViewer.core.data.repository

import com.example.artGalleryViewer.core.common.result.Result
import com.example.artGalleryViewer.core.common.result.Result.Error
import com.example.artGalleryViewer.core.common.result.Result.Success
import com.example.artGalleryViewer.core.model.Art
import com.example.artGalleryViewer.core.model.ArtObject
import com.example.artGalleryViewer.core.network.AgwNetworkDataSource
import com.example.artGalleryViewer.core.network.model.NetworkArt
import com.example.artGalleryViewer.core.network.model.asArtObject
import javax.inject.Inject

/**
 * Network backed implementation of the [ArtRepository].
 * @param agwDataSource The data source for the arts.
 */
class ArtRepositoryImpl @Inject constructor(
    private val agwDataSource: AgwNetworkDataSource
) : ArtRepository {

    override suspend fun getCollection(page: Int): Result<List<Art>> =
        try {
            val collection = agwDataSource.getCollection(page)
            Success(collection.map(NetworkArt::asArtObject))
        } catch (e: Exception) {
            Error(e)
        }


    override suspend fun getArt(objectId: String): Result<ArtObject> =
        try {
            val art = agwDataSource.getDetail(objectId)
            Success(art.asArtObject())
        } catch (e: Exception) {
            Error(e)
        }
}