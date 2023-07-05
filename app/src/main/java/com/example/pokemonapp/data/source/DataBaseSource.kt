package com.example.pokemonapp.data.source

import androidx.paging.PagingSource
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

    fun getPagedPokes(limit: Int, offset: Int): List<PokemonEntity> = pokemonDao.getPagedPokes(limit, offset)
}