package com.example.simplepokedex.presentation.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simplepokedex.domain.model.Pokemon
import com.example.simplepokedex.domain.usecase.FavoritePokemonUseCase
import com.example.simplepokedex.ui.UiState
import com.example.simplepokedex.util.onError
import com.example.simplepokedex.util.onSuccess
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class FavoriteViewModel(
    private val favoritePokemonUseCase: FavoritePokemonUseCase
): ViewModel() {

    private val _favoritePokemon = MutableStateFlow<UiState<List<Pokemon>>>(UiState.Loading)
    val favoritePokemon = _favoritePokemon.asStateFlow()

    init {
        getAllFavoritePokemon()
    }

    fun getAllFavoritePokemon() {
        viewModelScope.launch {
            favoritePokemonUseCase.getAllFavoritePokemon().collectLatest { result ->
                result.onSuccess {
                    _favoritePokemon.value = UiState.Success(it)
                }.onError {
                    _favoritePokemon.value = UiState.Error(it.toString())
                }
            }
        }
    }
}