package com.example.artGalleryViewer.core.network.fake

import com.example.artGalleryViewer.core.network.AgwNetworkDataSource
import com.example.artGalleryViewer.core.network.model.Label
import com.example.artGalleryViewer.core.network.model.NetworkArt
import com.example.artGalleryViewer.core.network.model.NetworkArtObject
import com.example.artGalleryViewer.core.network.model.NetworkWebImage

class FakeRetrofitAGWNetwork : AgwNetworkDataSource {
    override suspend fun getCollection(page: Int): List<NetworkArt>
    = networkArts
    override suspend fun getDetail(objectId: String): NetworkArtObject = networkArtObject

    companion object {

        val networkArtObject = NetworkArtObject(
            objectNumber = "1",
            webImage = NetworkWebImage(
                guid = "1",
                offsetPercentageX = 0,
                offsetPercentageY = 0,
                width = 100,
                height = 100,
                url = "https://example.com/image1.jpg"
            ),
            label = Label(
                title = "Art 1",
                makerLine = "Maker 1",
                description = "Description 1",
                notes = "Notes 1",
                date = "Date 1",
            )
        )
        val networkArts = listOf(
            NetworkArt(
                objectNumber = "1",
                title = "Art 1",
                longTitle = "Art 1 long title",
                networkWebImage = NetworkWebImage(
                    guid = "1",
                    offsetPercentageX = 0,
                    offsetPercentageY = 0,
                    width = 100,
                    height = 100,
                    url = "https://example.com/image1.jpg"
                ),
                productionPlaces = listOf("Place 1", "Place 2"),
            ),
            NetworkArt(
                objectNumber = "2",
                title = "Art 1",
                longTitle = "Art 1 long title",
                networkWebImage = NetworkWebImage(
                    guid = "2",
                    offsetPercentageX = 0,
                    offsetPercentageY = 0,
                    width = 100,
                    height = 100,
                    url = "https://example.com/image1.jpg"
                ),
                productionPlaces = listOf("Place 1", "Place 2"),
            ),
            NetworkArt(
                objectNumber = "3",
                title = "Art 1",
                longTitle = "Art 1 long title",
                networkWebImage = NetworkWebImage(
                    guid = "1",
                    offsetPercentageX = 0,
                    offsetPercentageY = 0,
                    width = 100,
                    height = 100,
                    url = "https://example.com/image1.jpg"
                ),
                productionPlaces = listOf("Place 1", "Place 2"),
            ),
        )
    }
}
