package com.example.movies.domain

sealed interface ResultState<out T> {
    data class Success<T>(val data: T): ResultState<T>
    data class Error(val error: String): ResultState<Nothing>
}