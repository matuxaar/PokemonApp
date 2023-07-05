package com.example.pokemonapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.example.pokemonapp.databinding.ItemPokemonBinding
import com.example.pokemonapp.domain.model.Pokemon

class PokemonAdapter(
    private val itemClickListener: (Pokemon) -> Unit
) : PagingDataAdapter<Pokemon, PokemonHolder>(PokemonDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonHolder {
        val item = ItemPokemonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonHolder(item, itemClickListener)
    }

    override fun onBindViewHolder(holder: PokemonHolder, position: Int) {
        val item = getItem(position) ?: return
        holder.onBind(item)
    }

}