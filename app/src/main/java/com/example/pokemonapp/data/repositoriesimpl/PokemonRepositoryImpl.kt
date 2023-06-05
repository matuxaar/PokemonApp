package com.example.pokemonapp.data.repositoriesimpl

import com.example.pokemonapp.data.models.PokemonResponse
import com.example.pokemonapp.data.network.PokemonService
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val pokemonService: PokemonService
) : PokemonService {

    override suspend fun getPoke(): List<PokemonResponse> {
        TODO("Not yet implemented")
    }
}