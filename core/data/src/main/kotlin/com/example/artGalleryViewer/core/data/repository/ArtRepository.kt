package com.example.artGalleryViewer.core.data.repository

import com.example.artGalleryViewer.core.common.result.Result
import com.example.artGalleryViewer.core.model.Art
import com.example.artGalleryViewer.core.model.ArtObject

/**
 * Data layer interface for the arts
 */
interface ArtRepository {
    /**
     * Returns a list of [Art]s.
     */
    suspend fun getCollection(page: Int): Result<List<Art>>

    /**
     * Returns an [ArtObject] with the given [objectId].
     */
    suspend fun getArt(objectId: String): Result<ArtObject>
}
