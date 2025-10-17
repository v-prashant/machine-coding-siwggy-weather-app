package com.example.movies.presentation

sealed interface UIState<out T> {
    data object Loading: UIState<Nothing>
    data class Success<T>(val data: T): UIState<T>
    data class Error(val error: String): UIState<Nothing>
}