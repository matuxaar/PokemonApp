package com.example.pokemonapp.data.source

import com.example.pokemonapp.data.database.PokemonDao
import javax.inject.Inject

class DataBaseSource @Inject constructor(
    private val pokemonDao: PokemonDao
) {

    fun getById() = pokemonDao.getById()

    fun getEvolutionById() = pokemonDao.getEvolutionById()

    fun getAll() = pokemonDao.getAll()
}