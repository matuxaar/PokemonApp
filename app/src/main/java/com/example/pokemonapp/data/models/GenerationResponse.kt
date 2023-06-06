package com.example.pokemonapp.data.models

import com.squareup.moshi.Json

data class GenerationResponse(
    @Json(name = "id") val id: Int? = null,
    @Json(name = "title") val title: Int? = null,
    @Json(name = "image") val image: Int? = null
)
