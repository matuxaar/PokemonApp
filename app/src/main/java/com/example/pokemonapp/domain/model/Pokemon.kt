package com.example.pokemonapp.domain.model

data class Pokemon(
    var id: String,
    var name: String,
    var abilities: List<String>,
    var attack: Int,
    var category: String,
    var defense: Int,
    var base_exp: String,
    var evolutions: List<String>,
    var evolvedfrom: String,
    var female_percentage: String,
    var genderless: Int,
    var height: String,
    var hp: Int,
    var imageUrl: String,
    var male_percentage: String,
    var reason: String,
    var special_attack: Int,
    var special_defense: Int,
    var speed: Int,
    var total: Int,
    var typeofpokemon: List<String>,
    var weakness: List<String>,
    var weight: String,
    var ydescription: String
)
