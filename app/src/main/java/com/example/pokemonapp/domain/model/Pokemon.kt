package com.example.pokemonapp.domain.model

data class Pokemon(
    val id: String,
    val name: String,
    val abilities: List<String>,
    val attack: Int,
    val category: String,
    val defense: Int,
    val base_exp: String,
    val evolutions: List<String>,
    val evolvedfrom: String,
    val height: String,
    val hp: Int,
    val imageUrl: String,
    val reason: String,
    val special_attack: Int,
    val special_defense: Int,
    val speed: Int,
    val total: Int,
    val typeofpokemon: List<String>,
    val weakness: List<String>,
    val weight: String,
    val ydescription: String
)
