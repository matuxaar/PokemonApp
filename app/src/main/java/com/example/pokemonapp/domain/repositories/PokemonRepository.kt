package com.example.pokemonapp.domain.repositories

import com.example.pokemonapp.domain.model.Pokemon
import retrofit2.Call

interface PokemonRepository {
    suspend fun getPoke(): List<Pokemon>

    suspend fun getAll(): List<Pokemon>

    suspend fun getPokemonById(): Pokemon

    suspend fun getPokemonEvolutionsByIds(): Pokemon
}