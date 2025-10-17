package com.example.movies.data

import com.example.movies.data.response.CityResponseItem
import retrofit2.http.GET

interface ApiService {

    @GET("/locations/v1/cities/search")
    suspend fun getCities(
        @retrofit2.http.Query(value = "q") city: String,
        @retrofit2.http.Query(value = "apiKey") apiKey: String = "empty_api_key"
        ): List<CityResponseItem>

}