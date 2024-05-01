package com.example.artGalleryViewer.core.testing.repository

import com.example.artGalleryViewer.core.common.result.Result
import com.example.artGalleryViewer.core.data.repository.ArtRepository
import com.example.artGalleryViewer.core.model.Art
import com.example.artGalleryViewer.core.model.ArtObject
import com.example.artGalleryViewer.core.model.WebImage
import kotlin.random.Random

class TestArtsRepository : ArtRepository {

    var arts = testArts
    val artObject = ArtObject(
        objectNumber = "1",
        title = "Title 1",
        webImage = WebImage(
            url = "https://example.com/1.jpg",
            width = 100,
            height = 100,
            guid = "guid 1",
            offsetPercentageX = 10,
            offsetPercentageY = 10
        ),
        description = "Description 1",
        url = "https://example.com/1",
    )

    override suspend fun getCollection(page: Int): Result<List<Art>>
    = Result.Success(arts)

    override suspend fun getArt(objectId: String): Result<ArtObject> =
        Result.Success(artObject)

    fun clear() {
        arts = emptyList()
    }

    companion object {
        val testArts = listOf(
            Art(
                objectNumber = Random.nextInt(0, 100).toString(),
                title = "Title 1",
                longTitle = "longTitle 1",
                productionPlaces = listOf("place 1", "place 2"),
                webImage = WebImage(
                    url = "https://example.com/1.jpg",
                    width = 100,
                    height = 100,
                    guid = "guid 1",
                    offsetPercentageX = 10,
                    offsetPercentageY = 10
                )
            ),
            Art(
                objectNumber = Random.nextInt(0, 100).toString(),
                title = "Title 1",
                longTitle = "longTitle 1",
                productionPlaces = listOf("place 1", "place 2"),
                webImage = WebImage(
                    url = "https://example.com/1.jpg",
                    width = 100,
                    height = 100,
                    guid = "guid 1",
                    offsetPercentageX = 10,
                    offsetPercentageY = 10
                )
            ),
            Art(
                objectNumber = Random.nextInt(0, 100).toString(),
                title = "Title 1",
                longTitle = "longTitle 1",
                productionPlaces = listOf("place 1", "place 2"),
                webImage = WebImage(
                    url = "https://example.com/1.jpg",
                    width = 100,
                    height = 100,
                    guid = "guid 1",
                    offsetPercentageX = 10,
                    offsetPercentageY = 10
                )
            ),
            Art(
                objectNumber = Random.nextInt(0, 100).toString(),
                title = "Title 1",
                longTitle = "longTitle 1",
                productionPlaces = listOf("place 1", "place 2"),
                webImage = WebImage(
                    url = "https://example.com/1.jpg",
                    width = 100,
                    height = 100,
                    guid = "guid 1",
                    offsetPercentageX = 10,
                    offsetPercentageY = 10
                )
            ),
            Art(
                objectNumber = Random.nextInt(0, 100).toString(),
                title = "Title 1",
                longTitle = "longTitle 1",
                productionPlaces = listOf("place 1", "place 2"),
                webImage = WebImage(
                    url = "https://example.com/1.jpg",
                    width = 100,
                    height = 100,
                    guid = "guid 1",
                    offsetPercentageX = 10,
                    offsetPercentageY = 10
                )
            ),
            Art(
                objectNumber = Random.nextInt(0, 100).toString(),
                title = "Title 1",
                longTitle = "longTitle 1",
                productionPlaces = listOf("place 1", "place 2"),
                webImage = WebImage(
                    url = "https://example.com/1.jpg",
                    width = 100,
                    height = 100,
                    guid = "guid 1",
                    offsetPercentageX = 10,
                    offsetPercentageY = 10
                )
            ),
            Art(
                objectNumber = Random.nextInt(0, 100).toString(),
                title = "Title 1",
                longTitle = "longTitle 1",
                productionPlaces = listOf("place 1", "place 2"),
                webImage = WebImage(
                    url = "https://example.com/1.jpg",
                    width = 100,
                    height = 100,
                    guid = "guid 1",
                    offsetPercentageX = 10,
                    offsetPercentageY = 10
                )
            ),
            Art(
                objectNumber = Random.nextInt(0, 100).toString(),
                title = "Title 1",
                longTitle = "longTitle 1",
                productionPlaces = listOf("place 1", "place 2"),
                webImage = WebImage(
                    url = "https://example.com/1.jpg",
                    width = 100,
                    height = 100,
                    guid = "guid 1",
                    offsetPercentageX = 10,
                    offsetPercentageY = 10
                )
            ),
            Art(
                objectNumber = Random.nextInt(0, 100).toString(),
                title = "Title 1",
                longTitle = "longTitle 1",
                productionPlaces = listOf("place 1", "place 2"),
                webImage = WebImage(
                    url = "https://example.com/1.jpg",
                    width = 100,
                    height = 100,
                    guid = "guid 1",
                    offsetPercentageX = 10,
                    offsetPercentageY = 10
                )
            ),
            Art(
                objectNumber = Random.nextInt(0, 100).toString(),
                title = "Title 1",
                longTitle = "longTitle 1",
                productionPlaces = listOf("place 1", "place 2"),
                webImage = WebImage(
                    url = "https://example.com/1.jpg",
                    width = 100,
                    height = 100,
                    guid = "guid 1",
                    offsetPercentageX = 10,
                    offsetPercentageY = 10
                )
            ),
            Art(
                objectNumber = Random.nextInt(0, 100).toString(),
                title = "Title 1",
                longTitle = "longTitle 1",
                productionPlaces = listOf("place 1", "place 2"),
                webImage = WebImage(
                    url = "https://example.com/1.jpg",
                    width = 100,
                    height = 100,
                    guid = "guid 1",
                    offsetPercentageX = 10,
                    offsetPercentageY = 10
                )
            ),
            Art(
                objectNumber = Random.nextInt(0, 100).toString(),
                title = "Title 1",
                longTitle = "longTitle 1",
                productionPlaces = listOf("place 1", "place 2"),
                webImage = WebImage(
                    url = "https://example.com/1.jpg",
                    width = 100,
                    height = 100,
                    guid = "guid 1",
                    offsetPercentageX = 10,
                    offsetPercentageY = 10
                )
            ),
            Art(
                objectNumber = Random.nextInt(0, 100).toString(),
                title = "Title 1",
                longTitle = "longTitle 1",
                productionPlaces = listOf("place 1", "place 2"),
                webImage = WebImage(
                    url = "https://example.com/1.jpg",
                    width = 100,
                    height = 100,
                    guid = "guid 1",
                    offsetPercentageX = 10,
                    offsetPercentageY = 10
                )
            ),
            Art(
                objectNumber = Random.nextInt(0, 100).toString(),
                title = "Title 1",
                longTitle = "longTitle 1",
                productionPlaces = listOf("place 1", "place 2"),
                webImage = WebImage(
                    url = "https://example.com/1.jpg",
                    width = 100,
                    height = 100,
                    guid = "guid 1",
                    offsetPercentageX = 10,
                    offsetPercentageY = 10
                )
            ),
            Art(
                objectNumber = Random.nextInt(0, 100).toString(),
                title = "Title 1",
                longTitle = "longTitle 1",
                productionPlaces = listOf("place 1", "place 2"),
                webImage = WebImage(
                    url = "https://example.com/1.jpg",
                    width = 100,
                    height = 100,
                    guid = "guid 1",
                    offsetPercentageX = 10,
                    offsetPercentageY = 10
                )
            ),
            Art(
                objectNumber = Random.nextInt(0, 100).toString(),
                title = "Title 1",
                longTitle = "longTitle 1",
                productionPlaces = listOf("place 1", "place 2"),
                webImage = WebImage(
                    url = "https://example.com/1.jpg",
                    width = 100,
                    height = 100,
                    guid = "guid 1",
                    offsetPercentageX = 10,
                    offsetPercentageY = 10
                )
            ),
            Art(
                objectNumber = Random.nextInt(0, 100).toString(),
                title = "Title 1",
                longTitle = "longTitle 1",
                productionPlaces = listOf("place 1", "place 2"),
                webImage = WebImage(
                    url = "https://example.com/1.jpg",
                    width = 100,
                    height = 100,
                    guid = "guid 1",
                    offsetPercentageX = 10,
                    offsetPercentageY = 10
                )
            )
        )
    }
}
