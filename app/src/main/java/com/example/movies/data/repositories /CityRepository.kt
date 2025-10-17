package com.example.movies.data.repositories

import com.example.movies.data.ApiService
import com.example.movies.data.response.CityResponseItem
import javax.inject.Inject

class CityRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getCities(city: String): List<CityResponseItem> {
        return apiService.getCities(city = city)
    }

}