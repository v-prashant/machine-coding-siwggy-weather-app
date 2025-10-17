package com.example.movies.presentation.ui.city

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.movies.presentation.UIState

@Composable
fun CityScreen() {

    val viewModel: CityViewModel = hiltViewModel()
    val city = remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp)
    ) {
        Column {
            Text(text = "Enter city name")
            TextField(
                onValueChange = { text ->
                    city.value = text
                    if(text.isNotBlank()){
                        viewModel.getCity(city.value)
                    }
                },
                value = city.value,
                label = {
                    Text(text = "")
                },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(
                modifier = Modifier.fillMaxWidth()
                    .padding(top = 16.dp)
            )

            val state = viewModel.state.value
            when(state) {
                is UIState.Loading -> {
                    Box(modifier = Modifier.fillMaxSize()) {
                        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                    }
                }
                is UIState.Success -> {
                    LazyColumn {
                        items(state.data){ city->
                            Text(text = city)
                        }
                    }
                }
                is UIState.Error -> {
                    Box(modifier = Modifier.fillMaxSize()) {
                        Text(text = state.error, modifier = Modifier.align(Alignment.Center))
                    }
                }
            }

        }
    }
}
