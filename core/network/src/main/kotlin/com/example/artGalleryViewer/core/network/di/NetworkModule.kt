package com.example.artGalleryViewer.core.network.di

import com.example.artGalleryViewer.core.network.AgwNetworkDataSource
import com.example.artGalleryViewer.core.network.BuildConfig
import com.example.artGalleryViewer.core.network.retrofit.AuthorizationInterceptor
import com.example.artGalleryViewer.core.network.retrofit.RIJKSMUSEUM_BASE_URL
import com.example.artGalleryViewer.core.network.retrofit.RetrofitAGWNetwork
import com.example.artGalleryViewer.core.network.retrofit.RijksmuseumNetworkApi
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @OptIn(ExperimentalSerializationApi::class)
    @Provides
    @Singleton
    fun providesNetworkJson(): Json = Json {
        ignoreUnknownKeys = true
        explicitNulls = false
    }

    @Singleton
    @Provides
    fun providesLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            if (BuildConfig.DEBUG) {
                level = HttpLoggingInterceptor.Level.BODY
            }
        }
    }

    @Provides
    fun provideServicesNetworkDataSource(
        rijksmuseumNetworkApi: RijksmuseumNetworkApi
    ): AgwNetworkDataSource = RetrofitAGWNetwork(rijksmuseumNetworkApi)

    @Provides
    @Singleton
    fun provideRetrofit(
        client: OkHttpClient,
        networkJson: Json
    ): Retrofit = Retrofit.Builder()
        .baseUrl(RIJKSMUSEUM_BASE_URL)
        .client(client)
        .addConverterFactory(
            networkJson.asConverterFactory("application/json".toMediaType())
        )
        .build()

    @Provides
    @Singleton
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
        authorizationInterceptor: AuthorizationInterceptor
    ): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .addInterceptor(authorizationInterceptor)
        .build()


    @Provides
    @Singleton
    fun provideRijksmuseumNetworkApi(retrofit: Retrofit): RijksmuseumNetworkApi =
        retrofit.create(RijksmuseumNetworkApi::class.java)
}
