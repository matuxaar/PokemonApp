package com.example.pokemonapp.data.repositoriesimpl

import com.example.pokemonapp.data.mappers.PokemonEntityMapper
import com.example.pokemonapp.data.mappers.PokemonMapper
import com.example.pokemonapp.data.mappers.PokemonToEntityMapper
import com.example.pokemonapp.data.network.PokemonService
import com.example.pokemonapp.data.source.DataBaseSource
import com.example.pokemonapp.domain.model.Pokemon
import com.example.pokemonapp.domain.repositories.PokemonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val pokemonEntityMapper: PokemonEntityMapper,
    private val pokemonMapper: PokemonMapper,
    private val dataBaseSource: DataBaseSource,
    private val pokemonToEntityMapper: PokemonToEntityMapper,
    private val pokemonService: PokemonService
) : PokemonRepository {

    override suspend fun getPoke() = withContext(Dispatchers.IO) {
        pokemonService.getPoke().map { pokemonMapper(it) }
    }

    override suspend fun getAll(): List<Pokemon> = withContext(Dispatchers.IO) {
        dataBaseSource.getAll().map { pokemonEntityMapper(it) }
    }

    override suspend fun getPokemonById(id: String): Pokemon = withContext(Dispatchers.IO) {
        pokemonEntityMapper(dataBaseSource.getById(id))
    }

    override suspend fun getPokemonEvolutionsByIds(id: List<String>): List<Pokemon> =
        withContext(Dispatchers.IO) {
            dataBaseSource.getEvolutionById(id).map { pokemonEntityMapper(it) }
        }

    override suspend fun addPokemons(pokemons: List<Pokemon>) = withContext(Dispatchers.IO) {
        dataBaseSource.addPokemons(pokemons.map { pokemonToEntityMapper(it) })
    }
}