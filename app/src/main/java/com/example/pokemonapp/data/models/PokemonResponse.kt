package com.example.pokemonapp.data.models

import com.squareup.moshi.Json

data class PokemonResponse(
    @Json(name = "id") var id: String? = null,
    @Json(name = "name") var name: String? = null,
    @Json(name = "abilities") var abilities: List<String>? = null,
    @Json(name = "attack") var attack: Int? = null,
    @Json(name = "category") var category: String? = null,
    @Json(name = "defense") var defense: Int? = null,
    @Json(name = "base_exp") var base_exp: String? = null,
    @Json(name = "evolutions") var evolutions: List<String>? = null,
    @Json(name = "evolvedfrom") var evolvedfrom: String? = null,
    @Json(name = "female_percentage") var female_percentage: String? = null,
    @Json(name = "genderless") var genderless: Int? = null,
    @Json(name = "height") var height: String? = null,
    @Json(name = "hp") var hp: Int? = null,
    @Json(name = "imageUrl") var imageUrl: String? = null,
    @Json(name = "male_percentage") var male_percentage: String? = null,
    @Json(name = "reason") var reason: String? = null,
    @Json(name = "special_attack") var special_attack: Int? = null,
    @Json(name = "special_defense") var special_defense: Int? = null,
    @Json(name = "speed") var speed: Int? = null,
    @Json(name = "total") var total: Int? = null,
    @Json(name = "typeofpokemon") var typeofpokemon: List<String>? = null,
    @Json(name = "weakness") var weakness: List<String>? = null,
    @Json(name = "weight") var weight: String? = null,
    @Json(name = "ydescription") var ydescription: String? = null
)