package com.example.movies.domain.usecase

import com.example.movies.data.repositories.CityRepository
import com.example.movies.data.response.CityResponseItem
import com.example.movies.domain.ResultState
import okio.IOException
import javax.inject.Inject

class GetCityUseCase @Inject constructor(
    private val repository: CityRepository
) {

    suspend operator fun invoke(city: String): ResultState<List<CityResponseItem>> {
        return try {
            val res = repository.getCities(city = city)
            ResultState.Success(res)
        } catch (ex: IOException){
            ResultState.Error(error = "No internet")
        } catch (ex: Exception) {
            ResultState.Error(error = ex.message.toString())
        }
    }

}