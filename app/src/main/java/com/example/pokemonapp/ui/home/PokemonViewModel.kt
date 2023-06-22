package com.example.pokemonapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemonapp.domain.model.Pokemon
import com.example.pokemonapp.domain.repositories.PokemonRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

class PokemonViewModel @Inject constructor(
    private val pokemonRepository: PokemonRepository
) : ViewModel() {

    private var _pokemonLiveData = MutableLiveData<List<Pokemon>>()
    val pokemonLiveData: LiveData<List<Pokemon>> get() = _pokemonLiveData

    private val exceptionHandler =
        CoroutineExceptionHandler { _, _ ->}


    fun getPokemonList() {
        viewModelScope.launch(exceptionHandler) {
            _pokemonLiveData.value = pokemonRepository.getAll()
        }
    }

    fun getPoke() {
        viewModelScope.launch(exceptionHandler) {
            _pokemonLiveData.value = pokemonRepository.getPoke()
        }
    }

    fun addPokemons(pokemons: List<Pokemon>) {
        viewModelScope.launch(exceptionHandler) {
            pokemonRepository.addPokemons(pokemons)
        }
    }

}