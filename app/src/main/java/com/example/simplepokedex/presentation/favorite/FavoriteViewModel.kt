package com.example.simplepokedex.presentation.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simplepokedex.domain.model.Pokemon
import com.example.simplepokedex.domain.usecase.PokemonUseCase
import com.example.simplepokedex.ui.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class FavoriteViewModel(
    private val pokemonUseCase: PokemonUseCase
): ViewModel() {

    private val _favoritePokemon = MutableStateFlow<UiState<List<Pokemon>>>(UiState.Loading)
    val favoritePokemon = _favoritePokemon.asStateFlow()

    init {
        getAllFavoritePokemon()
    }

    fun getAllFavoritePokemon() {
        viewModelScope.launch {
            pokemonUseCase.getFavoritePokemon().collectLatest { result ->
//                result.onSuccess {
//                    _favoritePokemon.value = UiState.Success(it)
//                }.onError {
//                    _favoritePokemon.value = UiState.Error(it.toString())
//                }
            }
        }
    }
}