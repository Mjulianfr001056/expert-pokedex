package com.example.simplepokedex.presentation.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.library.core.domain.model.Pokemon
import com.example.simplepokedex.domain.usecase.PokemonUseCase
import com.example.simplepokedex.ui.UiState
import com.example.simplepokedex.util.onError
import com.example.simplepokedex.util.onSuccess
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.lighthousegames.logging.logging

class HomeViewModel(
    private val pokemonUseCase: PokemonUseCase
) : ViewModel() {
    private val _pokemonList: MutableStateFlow<UiState<List<com.example.library.core.domain.model.Pokemon>>> = MutableStateFlow(UiState.Loading)
    val pokemonList = _pokemonList.asStateFlow()

    private val _query = mutableStateOf("")
    val query: State<String> get() = _query

    init {
        getAllPokemon()
    }

    private fun getAllPokemon() {
        viewModelScope.launch {
            pokemonUseCase.getAllPokemon()
                .collectLatest { pokemonList ->
                    pokemonList.onSuccess {
                        if(it.isEmpty()) {
                            _pokemonList.value = UiState.Success(emptyList())
                            log.d { "Empty list" }
                            return@onSuccess
                        }

                        _pokemonList.value = UiState.Success(it)
                        log.d { "Success: ${it.size}" }

                    }.onError {
                        _pokemonList.value = UiState.Error(it.toString())
                        log.d(TAG) {
                            "Error: $it"
                        }
                    }
                }
        }
    }

    fun search(newQuery: String){
        _query.value = newQuery
        viewModelScope.launch {
            pokemonUseCase.searchPokemon(newQuery)
                .collectLatest { pokemonList ->
                    pokemonList.onSuccess {
                        if(it.isEmpty()) {
                            _pokemonList.value = UiState.Success(emptyList())
                            log.d { "Empty list" }
                            return@onSuccess
                        }

                        _pokemonList.value = UiState.Success(it)
                        log.d { "Success: ${it.size}" }

                    }.onError {
                        _pokemonList.value = UiState.Error(it.toString())
                        log.d(TAG) {
                            "Error: $it"
                        }
                    }
                }
        }
    }

    companion object {
        const val TAG = "HomeViewModel"
        val log = logging()
    }
}