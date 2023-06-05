package com.example.pokemonapp.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query

@Dao
interface PokemonDao {

    @Query("SELECT * FROM pokemon_table")
    fun getById(id: String?): LiveData<PokemonEntity>

    @Query("SELECT * FROM pokemon_table")
    fun getEvolutionById(evolutionId: List<String>): LiveData<List<PokemonEntity>>

    @Query("SELECT * FROM pokemon_table")
    fun all(): LiveData<List<PokemonEntity>>
}