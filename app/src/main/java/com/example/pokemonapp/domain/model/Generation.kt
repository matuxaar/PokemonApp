package com.example.pokemonapp.domain.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Generation(
    val id: Int,
    @StringRes val title: Int,
    @DrawableRes val image: Int
) {
    override fun toString(): String = "$id$title$image"
}
