package com.example.pokemonapp.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.TypeConverters
import com.example.pokemonapp.data.database.converters.Converter

@Entity(tableName = "pokemon_table", primaryKeys = ["id", "name"])
@TypeConverters(Converter::class)
data class PokemonEntity(
    @ColumnInfo val id: String,
    @ColumnInfo val name: String,
    @ColumnInfo val abilities: List<String>,
    @ColumnInfo val attack: Int,
    @ColumnInfo val category: String,
    @ColumnInfo val defense: Int,
    @ColumnInfo val base_exp: String,
    @ColumnInfo val evolutions: List<String>,
    @ColumnInfo val evolvedfrom: String,
    @ColumnInfo val height: String,
    @ColumnInfo val hp: Int,
    @ColumnInfo val imageUrl: String,
    @ColumnInfo val reason: String,
    @ColumnInfo val special_attack: Int,
    @ColumnInfo val special_defense: Int,
    @ColumnInfo val speed: Int,
    @ColumnInfo val total: Int,
    @ColumnInfo val typeofpokemon: List<String>,
    @ColumnInfo val weakness: List<String>,
    @ColumnInfo val weight: String,
    @ColumnInfo val ydescription: String
)