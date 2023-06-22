package com.example.pokemonapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.pokemonapp.databinding.ItemPokemonBinding
import com.example.pokemonapp.domain.model.Pokemon

class PokemonAdapter(
    private val pokemonList: List<Pokemon>,
    private val itemClickListener: (Pokemon) -> Unit
) : RecyclerView.Adapter<PokemonHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonHolder {
        val item = ItemPokemonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonHolder(item, itemClickListener)
    }

    override fun getItemCount(): Int = pokemonList.size

    override fun onBindViewHolder(holder: PokemonHolder, position: Int) {
        val item = pokemonList[position]
        holder.onBind(item)
    }

}