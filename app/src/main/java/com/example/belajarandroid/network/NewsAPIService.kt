package com.example.belajarandroid.network

import com.example.belajarandroid.model.NewsData
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private val BASE_URL = "https://newsapi.org/v2/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface NewsAPIService {
    @GET("top-headlines?country=us&apiKey=2a78c5b43e5847ac8f95fc1d5fa310s1")
    suspend fun getTopHeadline(): NewsData
}

object Api {
    val newsApiService: NewsAPIService by lazy {
        retrofit.create(NewsAPIService::class.java)
    }
}
