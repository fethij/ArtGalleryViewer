package com.example.artGalleryViewer.core.domain

import com.example.artGalleryViewer.core.testing.repository.TestArtsRepository
import com.example.artGalleryViewer.core.testing.util.MainDispatcherRule
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class GetArtDetailUseCaseTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()
    private val articleRepository = TestArtsRepository()
    val useCase = GetArtDetailUseCase(articleRepository)

    @Test
    fun `GetArtDetailUseCase is backed by ArtRepository`() = runTest {
        val artObject = useCase("")
        assertEquals(articleRepository.artObject, artObject)
    }
}