package com.example.pokemonapp.domain.repositories

import com.example.pokemonapp.domain.model.Pokemon
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface PokemonRepository {

    @GET("pokemon.json")
    fun getPoke(): Flow<List<Pokemon>>
}