package com.example.artGalleryViewer.feature.arts

import com.example.artGalleryViewer.core.domain.GetArtsUseCase
import com.example.artGalleryViewer.core.testing.repository.TestArtsRepository
import com.example.artGalleryViewer.core.testing.util.MainDispatcherRule
import com.example.artGalleryViewer.feature.arts.gallery.GalleryViewModel
import com.example.artGalleryViewer.feature.arts.gallery.model.ArtsUiState
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals

class ArtViewModelTest {
    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val artsRepository = TestArtsRepository()
    private val useCase = GetArtsUseCase(artsRepository)
    private lateinit var viewModel: GalleryViewModel

    @Before
    fun setUp() {
        viewModel = GalleryViewModel(useCase)
    }

    @Test
    fun `state is initially Loading`() = runTest {
        assertEquals(
            ArtsUiState.Loading,
            viewModel.uiState.value,
        )
    }

    @Test
    fun `state is success when arts are available and not empty`() = runTest {
        viewModel = GalleryViewModel(useCase)
        val collectJob =
            launch(UnconfinedTestDispatcher()) { viewModel.uiState.collect() }
        assertEquals(
            ArtsUiState.Success(artsRepository.arts),
            viewModel.uiState.value,
        )
        collectJob.cancel()
    }

    @Test
    fun `state is Empty when arts are empty`() = runTest {
        artsRepository.clear()
        viewModel = GalleryViewModel(useCase)
        val collectJob =
            launch(UnconfinedTestDispatcher()) { viewModel.uiState.collect() }
        assertEquals(
            ArtsUiState.Empty,
            viewModel.uiState.value,
        )
        collectJob.cancel()
    }
}