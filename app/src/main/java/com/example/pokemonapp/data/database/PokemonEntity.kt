package com.example.pokemonapp.data.database

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.pokemonapp.data.database.converters.Converter

@Entity(tableName = "pokemon_table")
@TypeConverters(Converter::class)
data class PokemonEntity(
    @PrimaryKey
    @ColumnInfo val id: String,
    @ColumnInfo val name: String,
    @ColumnInfo val abilities: List<String>,
    @ColumnInfo val attack: Int,
    @ColumnInfo val category: String,
    @ColumnInfo val defense: Int,
    @ColumnInfo(name = "base_exp") val baseExp: String,
    @ColumnInfo val evolutions: List<String>,
    @ColumnInfo(name = "evolved_from") val evolvedFrom: String,
    @ColumnInfo val height: String,
    @ColumnInfo val hp: Int,
    @ColumnInfo(name = "image_url") val imageUrl: String,
    @ColumnInfo val reason: String,
    @ColumnInfo(name = "special_attack") val specialAttack: Int,
    @ColumnInfo(name = "special_defense") val specialDefense: Int,
    @ColumnInfo val speed: Int,
    @ColumnInfo val total: Int,
    @ColumnInfo(name = "type_of_pokemon") val typeOfPokemon: List<String>,
    @ColumnInfo val weaknesses: List<String>,
    @ColumnInfo val weight: String
)