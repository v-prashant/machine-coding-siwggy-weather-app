package com.example.movies.presentation

import kotlinx.serialization.Serializable

sealed interface Routes {
    @Serializable
    data object CityNav: Routes
}