package com.example.pokemonapp.utils

import android.content.Context
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import com.example.pokemonapp.R
import java.util.Locale

class ColorUtil(
    private var context: Context
) {

    @ColorInt
    fun getPokemonColor(typeOfPokemon: List<String>?): Int {
        val type = typeOfPokemon?.getOrNull(0)
        val color = when(type?.lowercase()) {
            "grass", "bug" -> R.color.lightTeal
            "fire" -> R.color.lightRed
            "water", "fighting", "normal" -> R.color.lightBlue
            "electric", "physic" -> R.color.lightYellow
            "poison", "ghost" -> R.color.lightPurple
            "ground", "rock" -> R.color.lightBrown
            "dark" -> R.color.lightBlack
            else -> R.color.lightBlue
        }
        return converterColor(color)
    }

    @ColorInt
    fun converterColor(@ColorRes color: Int): Int {
        return ContextCompat.getColor(context, color)
    }
}