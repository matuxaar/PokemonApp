package com.example.pokemonapp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemonapp.domain.model.Pokemon
import com.example.pokemonapp.domain.repositories.PokemonRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

class PokemonViewModel @Inject constructor(
    private val pokemonRepository: PokemonRepository
) : ViewModel() {

    val pokemon = flow<List<Pokemon>> {
        pokemonRepository.getPoke()
    }.stateIn(viewModelScope, SharingStarted.Eagerly, emptyList())

    //fun getPokemonList() = pokemonRepository.getAll()

}