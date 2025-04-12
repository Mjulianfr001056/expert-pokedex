package com.example.dfm.favorite.presentation.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.library.core.domain.model.Pokemon
import com.example.library.core.domain.usecase.PokemonUseCase
import com.example.library.core.ui.UiState
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
//        getAllFavoritePokemon()
    }

//    fun getAllFavoritePokemon() {
//        viewModelScope.launch {
//            pokemonUseCase.getAllPokemon().collectLatest { result ->
//                result.onSuccess {
//                    _favoritePokemon.value = UiState.Success(it)
//                }.onError {
//                    _favoritePokemon.value = UiState.Error(it.toString())
//                }
//            }
//        }
//    }
}