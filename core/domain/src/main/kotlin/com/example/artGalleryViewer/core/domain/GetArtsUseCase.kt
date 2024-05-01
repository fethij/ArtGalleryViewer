package com.example.artGalleryViewer.core.domain

import com.example.artGalleryViewer.core.common.result.Result
import com.example.artGalleryViewer.core.data.repository.ArtRepository
import com.example.artGalleryViewer.core.model.Art
import javax.inject.Inject

/**
 * Use case which gets [Art]s
 */
class GetArtsUseCase @Inject constructor(
    private val artRepository: ArtRepository
) {
    suspend operator fun invoke(page: Int = 1): List<Art> =
        when (val arts = artRepository.getCollection(page)) {
            is Result.Success -> arts.data
            is Result.Error -> emptyList() /* Could be handled in viewModel as well */
        }
}