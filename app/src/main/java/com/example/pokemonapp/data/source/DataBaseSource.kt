package com.example.pokemonapp.data.source

import com.example.pokemonapp.data.database.PokemonDao
import com.example.pokemonapp.data.database.PokemonEntity
import javax.inject.Inject

class DataBaseSource @Inject constructor(
    private val pokemonDao: PokemonDao
) {

    suspend fun getById(id: String) = pokemonDao.getById(id)

    suspend fun getEvolutionById(id: List<String>): List<PokemonEntity> = pokemonDao.getEvolutionById(id)

    suspend fun getAll() = pokemonDao.getAll()

    suspend fun addPokemons(pokemons: List<PokemonEntity>) = pokemonDao.addPokemons(pokemons)
}