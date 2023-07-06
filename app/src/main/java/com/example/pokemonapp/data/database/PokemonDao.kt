package com.example.pokemonapp.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PokemonDao {

    @Query("SELECT * FROM pokemon_table WHERE id = :id")
    suspend fun getById(id: String): PokemonEntity

    @Query("SELECT * FROM pokemon_table WHERE id IN(:evolutionId)")
    suspend fun getEvolutionById(evolutionId: List<String>): List<PokemonEntity>

    @Query("SELECT * FROM pokemon_table")
    suspend fun getAll(): List<PokemonEntity>

    @Query("SELECT * FROM pokemon_table ORDER BY id ASC LIMIT :limit OFFSET :offset")
    fun getPagedPokes(limit: Int, offset: Int): List<PokemonEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPokemons(pokemon: List<PokemonEntity>)

}