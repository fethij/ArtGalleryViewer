package com.example.artGalleryViewer.core.network.di

import com.example.artGalleryViewer.core.network.AgwNetworkDataSource
import com.example.artGalleryViewer.core.network.fake.FakeRetrofitAGWNetwork
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [NetworkModule::class],
)
object FakeNetworkModule {
    @Provides
    fun provideServicesNetworkDataSource(): AgwNetworkDataSource = FakeRetrofitAGWNetwork()
}