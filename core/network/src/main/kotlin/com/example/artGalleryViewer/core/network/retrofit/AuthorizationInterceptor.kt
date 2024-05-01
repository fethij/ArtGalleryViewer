package com.example.artGalleryViewer.core.network.retrofit

import com.example.artGalleryViewer.core.network.BuildConfig
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject

private const val KEY = "key"

/**
 * Interceptor that attaches the API key to the request.
 * The API key is required to access the Rijksmuseum API.
 */
class AuthorizationInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest = chain.request().tokenAttachedRequest()
        return chain.proceed(newRequest)
    }

    private fun Request.tokenAttachedRequest(): Request {
        val apiKey = BuildConfig.RijksmuseumApiKey
        return newBuilder()
            .url(url.newBuilder().addQueryParameter(KEY, apiKey).build())
            .build()
    }
}