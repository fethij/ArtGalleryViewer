package com.example.artGalleryViewer.core.domain

import com.example.artGalleryViewer.core.common.result.Result
import com.example.artGalleryViewer.core.data.repository.ArtRepository
import com.example.artGalleryViewer.core.model.Art
import com.example.artGalleryViewer.core.model.ArtObject
import javax.inject.Inject

/**
 * Use case to get art detail.
 */
class GetArtDetailUseCase @Inject constructor(
    private val artRepository: ArtRepository
) {
    suspend operator fun invoke(objectId: String): ArtObject? =
        when (val art = artRepository.getArt(objectId)) {
            is Result.Success -> art.data
            is Result.Error -> null /* Could be handled in viewModel as well */
        }
}