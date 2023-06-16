package com.example.pokemonapp.data.models

import com.example.pokemonapp.domain.model.Pokemon
import com.squareup.moshi.Json

data class PokemonResponse(
    @Json(name = "id") val id: String? = null,
    @Json(name = "name") val name: String? = null,
    @Json(name = "abilities") val abilities: List<String>? = null,
    @Json(name = "attack") val attack: Int? = null,
    @Json(name = "category") val category: String? = null,
    @Json(name = "defense") val defense: Int? = null,
    @Json(name = "base_exp") val baseExp: String? = null,
    @Json(name = "evolutions") val evolutions: List<String>? = null,
    @Json(name = "evolvedfrom") val evolvedFrom: String? = null,
    @Json(name = "height") val height: String? = null,
    @Json(name = "hp") val hp: Int? = null,
    @Json(name = "imageUrl") val imageUrl: String? = null,
    @Json(name = "reason") val reason: String? = null,
    @Json(name = "special_attack") val specialAttack: Int? = null,
    @Json(name = "special_defense") val specialDefense: Int? = null,
    @Json(name = "speed") val speed: Int? = null,
    @Json(name = "total") val total: Int? = null,
    @Json(name = "typeofpokemon") val typeOfPokemon: List<String>? = null,
    @Json(name = "weakness") val weakness: List<String>? = null,
    @Json(name = "weight") val weight: String? = null
)