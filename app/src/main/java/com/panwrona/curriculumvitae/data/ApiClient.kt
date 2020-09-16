package com.panwrona.curriculumvitae.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient: RestClient {
    private val url = "https://api.jsonbin.io/b/5f61d241ad23b57ef9132b1a/"

    private val api: ApiService

    init {
        api = Retrofit.Builder()
            .baseUrl(url)
            .client(OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }).build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    override suspend fun getCurriculumVitae() = api.getCurriculumVitae(url)
}