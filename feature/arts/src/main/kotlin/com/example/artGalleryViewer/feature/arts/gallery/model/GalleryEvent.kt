package com.example.artGalleryViewer.feature.arts.gallery.model

import com.example.artGalleryViewer.core.model.Art

sealed class GalleryEvent {
    data class ArtClicked(val art: Art) : GalleryEvent()
    data class PlaceFiltered(val place: String) : GalleryEvent()
}