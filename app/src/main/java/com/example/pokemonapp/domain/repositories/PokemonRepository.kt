package com.example.pokemonapp.domain.repositories

import androidx.paging.PagingData
import com.example.pokemonapp.domain.model.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {

    suspend fun getPoke(): List<Pokemon>

    suspend fun getAll(): List<Pokemon>

    suspend fun getPokemonById(id: String): Pokemon

    suspend fun getPokemonEvolutionsByIds(id: List<String>): List<Pokemon>

    suspend fun addPokemons(pokemons: List<Pokemon>)

    fun getPagedPokemon(): Flow<PagingData<Pokemon>>
}