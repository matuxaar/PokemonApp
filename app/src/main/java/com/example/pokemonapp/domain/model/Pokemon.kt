package com.example.pokemonapp.domain.model

data class Pokemon(
    val id: String,
    val name: String,
    val abilities: List<String>,
    val attack: Int,
    val category: String,
    val defense: Int,
    val baseExp: String,
    val evolutions: List<String>,
    val evolvedFrom: String,
    val height: String,
    val hp: Int,
    val imageUrl: String,
    val reason: String,
    val specialAttack: Int,
    val specialDefense: Int,
    val speed: Int,
    val total: Int,
    val typeOfPokemon: List<String>,
    val weaknesses: List<String>,
    val weight: String
)
