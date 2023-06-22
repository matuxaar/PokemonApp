package com.example.pokemonapp.data.network

import com.example.pokemonapp.data.models.PokemonResponse
import retrofit2.http.GET

interface PokemonService {
    @GET("pokemon.json")
    suspend fun getPoke(): List<PokemonResponse>
}