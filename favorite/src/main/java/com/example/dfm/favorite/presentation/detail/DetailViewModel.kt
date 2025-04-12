package com.example.dfm.favorite.presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.library.core.domain.model.Pokemon
import com.example.dfm.favorite.domain.usecase.FavoritePokemonUseCase
import com.example.library.core.domain.usecase.PokemonUseCase
import com.example.library.core.ui.UiState
import com.example.library.core.onError
import com.example.library.core.onSuccess
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.lighthousegames.logging.logging

class DetailViewModel(
    private val getPokemonUseCase: PokemonUseCase,
    private val favoritePokemonUseCase: FavoritePokemonUseCase
) : ViewModel() {

    private val _pokemon = MutableStateFlow<UiState<Pokemon>>(UiState.Loading)
    val pokemon = _pokemon.asStateFlow()

    private val _isFavorite = MutableStateFlow(false)
    val isFavorite = _isFavorite.asStateFlow()

    fun loadPokemon(id: Int) {
        viewModelScope.launch {
            coroutineScope {
                launch {
                    getPokemonUseCase.getPokemonById(id)
                        .collectLatest { result ->
                            result.onSuccess {
                                _pokemon.value = UiState.Success(it)
                            }
                                .onError {
                                    _pokemon.value = UiState.Error(it.toString())
                                }
                        }
                }
            }

            coroutineScope {
                launch {
                    favoritePokemonUseCase.isFavoritePokemon(id)
                        .collectLatest { result ->
                            result.onSuccess {
                                _isFavorite.value = it
                            }.onError {
                                logging().debug { "Error: $it" }
                            }
                        }
                }
            }
        }
    }

    fun saveToFavorite(pokemon: Pokemon) {
        viewModelScope.launch {
            favoritePokemonUseCase.savePokemon(pokemon.id)
        }
        loadPokemon(pokemon.id)
    }

    fun removeFromFavorite(pokemon: Pokemon) {
        viewModelScope.launch {
            favoritePokemonUseCase.deletePokemon(pokemon.id)
        }
        loadPokemon(pokemon.id)
    }
}