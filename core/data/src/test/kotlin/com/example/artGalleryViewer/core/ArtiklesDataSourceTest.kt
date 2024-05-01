package com.example.artGalleryViewer.core

import com.example.artGalleryViewer.core.common.result.Result
import com.example.artGalleryViewer.core.data.repository.ArtRepository
import com.example.artGalleryViewer.core.model.Art
import com.example.artGalleryViewer.core.network.AgwNetworkDataSource
import com.example.artGalleryViewer.core.network.model.NetworkArt
import com.example.artGalleryViewer.core.network.model.asArtObject
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import javax.inject.Inject
import kotlin.test.assertEquals


@RunWith(RobolectricTestRunner::class)
@Config(application = HiltTestApplication::class)
@HiltAndroidTest
class ArtRepositoryTest {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var agwNetworkDataSource: AgwNetworkDataSource

    @Inject
    lateinit var artRepository: ArtRepository

    @Before
    fun setUp() {
        hiltRule.inject()
    }

    @Test
    fun `ArtRepository is backed by AgwNetworkDataSource`() = runTest {
        val repositoryResult: List<Art> =
            (artRepository.getCollection(1) as Result.Success).data
        val dataSourceResult: List<Art> =
            agwNetworkDataSource.getCollection(1).map(NetworkArt::asArtObject)
        assertEquals(repositoryResult, dataSourceResult)
    }
}