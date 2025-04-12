package com.example.simplepokedex.presentation.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simplepokedex.domain.usecase.FavoritePokemonUseCase
import com.example.simplepokedex.ui.UiState
import id.ac.stis.sipadu.config.onError
import id.ac.stis.sipadu.config.onSuccess
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class FavoriteViewModel(
    private val favoritePokemonUseCase: FavoritePokemonUseCase
): ViewModel() {

    private val _favoritePokemon = MutableStateFlow<UiState<List<com.example.library.core.domain.model.Pokemon>>>(UiState.Loading)
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