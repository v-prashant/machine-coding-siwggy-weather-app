package com.example.movies.presentation.ui.city

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies.data.response.toDto
import com.example.movies.domain.ResultState
import com.example.movies.domain.usecase.GetCityUseCase
import com.example.movies.presentation.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CityViewModel @Inject constructor(
    private val getCityUseCase: GetCityUseCase
) : ViewModel() {

    private val _state = mutableStateOf<UIState<List<String>>>(UIState.Success(emptyList()))
    val state: State<UIState<List<String>>> = _state

    fun getCity(city: String) {
        _state.value = UIState.Loading
        viewModelScope.launch {
            val res  = getCityUseCase(city = city)
            when(res) {
                is ResultState.Success -> {
                    val data = ArrayList<String>()
                    res.data.map {
                        data.addAll(it.toDto())
                    }
                    _state.value = UIState.Success(data)
                }
                is ResultState.Error -> {
                    _state.value = UIState.Error(res.error)
                }
            }
        }
    }

}