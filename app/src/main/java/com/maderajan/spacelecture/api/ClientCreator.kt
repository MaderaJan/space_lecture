package com.maderajan.spacelecture.api

import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import java.util.concurrent.TimeUnit

object ClientCreator {

    private const val TIMEOUT = 30L

    private val networkJson = Json { ignoreUnknownKeys = true }

    fun createSpaceApi(): SpaceFlightsNewsApi {
        val okHttpClient = OkHttpClient.Builder().apply {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY

            addInterceptor(interceptor)

            connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            readTimeout(TIMEOUT, TimeUnit.SECONDS)
            writeTimeout(TIMEOUT, TimeUnit.SECONDS)
        }.build()

        return Retrofit.Builder()
            .baseUrl("https://api.spaceflightnewsapi.net/")
            .addConverterFactory(networkJson.asConverterFactory("application/json; charset=UTF8".toMediaType()))
            .client(okHttpClient)
            .build()
            .create(SpaceFlightsNewsApi::class.java)
    }
}