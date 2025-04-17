package com.example.dfm.favorite.presentation.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.filter
import com.example.dfm.favorite.domain.model.Favorite
import com.example.dfm.favorite.domain.usecase.FavoritePokemonUseCase
import com.example.library.core.domain.model.Pokemon
import com.example.library.core.domain.usecase.PokemonUseCase
import com.example.library.core.onError
import com.example.library.core.onSuccess
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import org.lighthousegames.logging.logging

class FavoriteViewModel(
    private val pokemonUseCase: PokemonUseCase,
    private val favoritePokemonUseCase: FavoritePokemonUseCase,
) : ViewModel() {

    private val _favoriteList = MutableStateFlow<List<Favorite>>(emptyList())
    private val _favoritePokemon = MutableStateFlow<PagingData<Pokemon>>(PagingData.empty())
    val favoritePokemon: StateFlow<PagingData<Pokemon>> get() = _favoritePokemon

    init {
        viewModelScope.launch {
            favoritePokemonUseCase.getAllFavoritePokemon().collectLatest { result ->
                result.onSuccess { favorites ->
                    _favoriteList.value = favorites
                    reloadFilteredPokemon(favorites)
                }.onError {
                    logging().error { "Error fetching favorite pokemon: $it" }
                }
            }
        }
    }

    private fun reloadFilteredPokemon(favorites: List<Favorite>) {
        viewModelScope.launch {
            pokemonUseCase.getLocalPokemon()
                .map { pagingData ->
                    pagingData.filter { pokemon ->
                        favorites.any { it.id == pokemon.id }
                    }
                }
                .cachedIn(viewModelScope)
                .collectLatest {
                    _favoritePokemon.value = it
                }
        }
    }
}
