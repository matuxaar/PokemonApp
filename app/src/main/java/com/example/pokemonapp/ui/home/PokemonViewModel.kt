package com.example.pokemonapp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.util.query
import com.example.pokemonapp.domain.model.Pokemon
import com.example.pokemonapp.domain.repositories.PokemonRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

class PokemonViewModel @Inject constructor(
    private val pokemonRepository: PokemonRepository
) : ViewModel() {

//    private val _pokemonMes = MutableStateFlow<List<String>>()
//    val pokemonMes: StateFlow<List<String>> = _pokemonMes.asStateFlow()
//
//    private val exceptionHandler = CoroutineExceptionHandler{ _, _ -> }
//    fun getPokemon() {
//        viewModelScope.launch(exceptionHandler) {
//
//        }
//    }

}