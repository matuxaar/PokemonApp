package com.example.pokemonapp.data.repositoriesimpl

import androidx.lifecycle.map
import com.example.pokemonapp.data.mappers.PokemonResponseMapper
import com.example.pokemonapp.data.source.DataBaseSource
import com.example.pokemonapp.domain.model.Pokemon
import com.example.pokemonapp.domain.repositories.PokemonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val pokemonResponseMapper: PokemonResponseMapper,
    private val dataBaseSource: DataBaseSource
) : PokemonRepository {

    override suspend fun getPoke(): List<Pokemon> {
        TODO("Not yet implemented")
    }

    override suspend fun getAll(): List<Pokemon> = TODO()// withContext(Dispatchers.IO) {
        //dataBaseSource.getAll().map { pokemonResponseMapper(it) }
        //}

    override suspend fun getPokemonById(): Pokemon {
        TODO("Not yet implemented")
    }

    override suspend fun getPokemonEvolutionsByIds(): Pokemon {
        TODO("Not yet implemented")
    }
}