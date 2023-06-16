package com.example.pokemonapp.domain.repositories

import com.example.pokemonapp.domain.model.Pokemon

interface PokemonRepository {

    suspend fun getPoke(): List<Pokemon>

    suspend fun getAll(): List<Pokemon>

    suspend fun getPokemonById(id: String?): Pokemon

    suspend fun getPokemonEvolutionsByIds(id: List<String>?): List<Pokemon>
}