package com.example.pokemonapp.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemonapp.domain.model.Pokemon
import com.example.pokemonapp.domain.repositories.PokemonRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    private val repository: PokemonRepository
): ViewModel() {

    private var _pokemonLiveData = MutableLiveData<Pokemon>()
    val pokemonLiveData: LiveData<Pokemon> get() = _pokemonLiveData

    private val _loadingLiveData = MutableLiveData<Boolean>()
    val loadingLiveData: LiveData<Boolean> get() = _loadingLiveData

    private val exceptionHandler =
        CoroutineExceptionHandler { _, _ ->}

    fun getByName(name: String) {
        _loadingLiveData.value = true
        viewModelScope.launch(exceptionHandler) {
            _pokemonLiveData.value = repository.getByName(name)
            _loadingLiveData.value = false
        }
    }
}