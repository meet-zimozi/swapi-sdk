package com.zimozi.swapi

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen
import com.squareup.moshi.Moshi
import com.zimozi.swapi.helpers.CacheMaxAgeInterceptor
import com.zimozi.swapi.helpers.Iso8601DateTimeTypeAdapter
import com.zimozi.swapi.helpers.OfflineCacheInterceptor
import com.zimozi.swapi.helpers.UserAgentInterceptor
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

internal val moshi by lazy {
    Moshi.Builder()
        .add(Iso8601DateTimeTypeAdapter())
        .build()
}

lateinit var swapiClient: Swapi

fun initializeSwapiClient(
    application: Application,
    httpClient: OkHttpClient = OkHttpClient(),
    useMirror: Boolean = false
) {
    AndroidThreeTen.init(application)

    val baseUrl = if (useMirror) {
        "https://gotev.github.io/swapi-android/"
    } else {
        "https://swapi.dev/api/"
    }

    val clientClass = if (useMirror) {
        SwapiMirror::class.java
    } else {
        Swapi::class.java
    }

    swapiClient = Retrofit.Builder()
        .client(
            httpClient.newBuilder()
                .cache(Cache(application.cacheDir, 10 * 1024 * 1024))
                .addInterceptor(OfflineCacheInterceptor())
                .addNetworkInterceptor(CacheMaxAgeInterceptor())
                .addNetworkInterceptor(
                    UserAgentInterceptor("swapi-sdk-android/${BuildConfig.VERSION_NAME}")
                ).build()
        )
        .baseUrl(baseUrl)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()
        .create(clientClass)
}
