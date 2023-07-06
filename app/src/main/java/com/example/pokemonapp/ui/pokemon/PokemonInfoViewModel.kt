package com.example.pokemonapp.ui.pokemon

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemonapp.domain.model.Pokemon
import com.example.pokemonapp.domain.repositories.PokemonRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class PokemonInfoViewModel @Inject constructor(
    private val pokemonRepository: PokemonRepository
) : ViewModel() {

    private var _pokemonSharedFlow = MutableSharedFlow<Pokemon>()
    val pokemonSharedFlow: SharedFlow<Pokemon> get() = _pokemonSharedFlow

    private var _pokemonListStateFlow = MutableStateFlow<List<Pokemon>>(emptyList())
    val pokemonListStateFlow: StateFlow<List<Pokemon>> get() = _pokemonListStateFlow


    private val exceptionHandler =
        CoroutineExceptionHandler { _, _ -> }

    fun getPokemonById(id: String) {
        viewModelScope.launch(exceptionHandler) {
            val pokemon = pokemonRepository.getPokemonById(id)
            _pokemonSharedFlow.emit(pokemon)
        }
    }

    fun getPokemonEvolutionsByIds(id: List<String>) {
        viewModelScope.launch(exceptionHandler) {
            _pokemonListStateFlow.value = pokemonRepository.getPokemonEvolutionsByIds(id)
        }
    }

}