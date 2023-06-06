package com.example.pokemonapp.domain.model

data class Generation(
    val id: Int,
    val title: Int,
    val image: Int
) {
    override fun toString(): String = "$id$title$image"
}
