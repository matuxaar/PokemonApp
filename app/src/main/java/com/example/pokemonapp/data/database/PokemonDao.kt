package com.example.pokemonapp.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query

@Dao
interface PokemonDao {

    @Query("SELECT * FROM pokemon_table")
    fun getById(): LiveData<PokemonEntity>

    @Query("SELECT * FROM pokemon_table")
    fun getEvolutionById(): LiveData<List<PokemonEntity>>

    @Query("SELECT * FROM pokemon_table")
    fun getAll(): LiveData<List<PokemonEntity>>
}