package com.example.artGalleryViewer.core.data.di

import com.example.artGalleryViewer.core.data.repository.ArtRepository
import com.example.artGalleryViewer.core.data.repository.ArtRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindsArtRepository(
        artRepositoryImpl: ArtRepositoryImpl,
    ): ArtRepository
}
