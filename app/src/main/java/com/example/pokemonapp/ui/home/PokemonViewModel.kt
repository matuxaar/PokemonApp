package com.example.pokemonapp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.pokemonapp.domain.model.Pokemon
import com.example.pokemonapp.domain.repositories.PokemonRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class PokemonViewModel @Inject constructor(
    private val pokemonRepository: PokemonRepository
) : ViewModel() {

    private var _pokemonStateFlow = MutableStateFlow<List<Pokemon>>(emptyList())
    val pokemonStateFlow: StateFlow<List<Pokemon>> get() = _pokemonStateFlow

    private val _pokemonFlow: MutableStateFlow<PagingData<Pokemon>> = MutableStateFlow(PagingData.empty())
    val pokemonFlow: StateFlow<PagingData<Pokemon>> get() = _pokemonFlow


    private val exceptionHandler =
        CoroutineExceptionHandler { _, _ ->}

    init {
        viewModelScope.launch(exceptionHandler) {
            pokemonRepository.getPoke()
            getPagedPokemon().collect {
                _pokemonFlow.value = it
            }
        }
        getPokemonList()
    }

    fun getPagedPokemon(): Flow<PagingData<Pokemon>> {
        return pokemonRepository.getPagedPokemon().cachedIn(viewModelScope)
    }

    fun getPokemonList() {
        viewModelScope.launch(exceptionHandler) {
            pokemonRepository.getAll()
        }
    }

    fun addPokemons(pokemons: List<Pokemon>) {
        viewModelScope.launch(exceptionHandler) {
            pokemonRepository.addPokemons(pokemons)
        }
    }

}