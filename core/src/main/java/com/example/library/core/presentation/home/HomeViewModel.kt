package com.example.library.core.presentation.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.library.core.domain.model.Pokemon
import com.example.library.core.domain.usecase.PokemonUseCase
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HomeViewModel(
    private val pokemonUseCase: PokemonUseCase
) : ViewModel() {

    private val _pokemonList = MutableStateFlow<PagingData<Pokemon>>(PagingData.empty())
    val pokemonList = _pokemonList.asStateFlow()

    private val _query = mutableStateOf("")
    val query: State<String> get() = _query

    private var currentJob: Job? = null

    init {
        getAllPokemon()
    }

    private fun getAllPokemon() {
        currentJob?.cancel()
        currentJob = viewModelScope.launch {
            pokemonUseCase.getAllPokemon()
                .cachedIn(viewModelScope)
                .collectLatest { _pokemonList.value = it }
        }
    }

    fun search(newQuery: String) {
        _query.value = newQuery
        currentJob?.cancel()
        currentJob = viewModelScope.launch {
            pokemonUseCase.searchPokemon(newQuery)
                .cachedIn(viewModelScope)
                .collectLatest { _pokemonList.value = it }
        }
    }
}
