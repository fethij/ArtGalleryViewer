package com.example.artGalleryViewer

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import coil.disk.DiskCache
import coil.memory.MemoryCache
import coil.request.CachePolicy
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ArtGalleryViewerApplication : Application(), ImageLoaderFactory {

    /**
     * Coil's [ImageLoader] to handle caching and fetching images.
     */
    override fun newImageLoader(): ImageLoader = ImageLoader(this)
        .newBuilder()
        .memoryCachePolicy(CachePolicy.ENABLED)
        .memoryCache {
            MemoryCache.Builder(this)
                .maxSizePercent(0.25)
                .strongReferencesEnabled(true)
                .build()
        }
        .diskCachePolicy(CachePolicy.ENABLED)
        .diskCache {
            DiskCache.Builder()
                .directory(cacheDir)
                .maxSizePercent(0.1)
                .build()
        }
        .build()
}