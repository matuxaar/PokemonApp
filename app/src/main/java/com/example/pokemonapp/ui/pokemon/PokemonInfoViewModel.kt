package com.example.pokemonapp.ui.pokemon

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemonapp.domain.model.Pokemon
import com.example.pokemonapp.domain.repositories.PokemonRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

class PokemonInfoViewModel @Inject constructor(
    private val pokemonRepository: PokemonRepository
) : ViewModel() {

    private var _pokemonLiveData = MutableLiveData<Pokemon>()
    val pokemonLiveData: LiveData<Pokemon> get() = _pokemonLiveData

    private var _pokemonListLiveData = MutableLiveData<List<Pokemon>>()
    val pokemonListLiveData: LiveData<List<Pokemon>> get() = _pokemonListLiveData


    private val exceptionHandler =
        CoroutineExceptionHandler { _, _ -> }

    fun getPokemonById(id: String) {
        viewModelScope.launch(exceptionHandler) {
            _pokemonLiveData.value = pokemonRepository.getPokemonById(id)
        }
    }

    fun getPokemonEvolutionsByIds(id: List<String>) {
        viewModelScope.launch(exceptionHandler) {
            _pokemonListLiveData.value = pokemonRepository.getPokemonEvolutionsByIds(id)
        }
    }

}