package com.example.pokemonapp.data.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.squareup.moshi.Json

data class GenerationResponse(
    val id: Int? = null,
    @StringRes val title: Int? = null,
    @DrawableRes val image: Int? = null
)
