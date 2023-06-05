package com.example.pokemonapp.domain.repositories

import com.example.pokemonapp.domain.model.Pokemon
import retrofit2.Call

interface PokemonRepository {
    fun getPoke(): Call<List<Pokemon>>
}