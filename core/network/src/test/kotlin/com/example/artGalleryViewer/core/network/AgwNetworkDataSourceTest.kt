package com.example.artGalleryViewer.core.network

import com.example.artGalleryViewer.core.network.fake.FakeRetrofitAGWNetwork.Companion.networkArtObject
import com.example.artGalleryViewer.core.network.fake.FakeRetrofitAGWNetwork.Companion.networkArts
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
class AgwNetworkDataSourceTest {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var agwNetworkDataSource: AgwNetworkDataSource

    @Before
    fun setUp() {
        hiltRule.inject()
    }

    @Test
    fun getCollectionTest() = runTest {
        val dataSourceResult = agwNetworkDataSource.getCollection(1)
        assertEquals(networkArts.size, dataSourceResult.size)
        assertEquals(networkArts.first(), dataSourceResult.first())
    }

    @Test
    fun getDetailTest() = runTest {
        val dataSourceResult = agwNetworkDataSource.getDetail("1")
        assertEquals(networkArtObject, dataSourceResult)
    }
}