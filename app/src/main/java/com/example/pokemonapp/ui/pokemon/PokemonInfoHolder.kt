package com.example.pokemonapp.ui.pokemon

import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapp.databinding.FragmentPokemonInfoBinding

class PokemonInfoHolder(
    private val binding: FragmentPokemonInfoBinding,
    private val itemCategoryCLick: (String) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
}