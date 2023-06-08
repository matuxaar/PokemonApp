package com.example.pokemonapp.ui.pokemon

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.pokemonapp.data.database.PokemonDao
import com.example.pokemonapp.data.database.PokemonEntity
import com.example.pokemonapp.domain.model.Pokemon
import javax.inject.Inject

class PokemonInfoViewModel @Inject constructor(private val pokemonDao: PokemonDao) : ViewModel() {

    fun getPokemonById(id: String?): LiveData<PokemonEntity> {
        return pokemonDao.getById()
    }

    fun getPokemonEvolutionsByIds(id: List<String>): LiveData<List<PokemonEntity>> {
        return pokemonDao.getEvolutionById()
    }
}