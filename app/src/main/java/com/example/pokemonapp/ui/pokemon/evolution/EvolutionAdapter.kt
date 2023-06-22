package com.example.pokemonapp.ui.pokemon.evolution

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapp.data.database.PokemonEntity
import com.example.pokemonapp.databinding.ItemPokemonBinding
import com.example.pokemonapp.domain.model.Pokemon

class EvolutionAdapter() : RecyclerView.Adapter<EvolutionHolder>() {

    private var pokemonList: MutableList<Pokemon> = mutableListOf()

    fun setList(list: List<Pokemon>) {
        pokemonList.clear()
        pokemonList.addAll(list)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EvolutionHolder {
        val view = ItemPokemonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EvolutionHolder(view)
    }

    override fun getItemCount(): Int = pokemonList.size

    override fun onBindViewHolder(holder: EvolutionHolder, position: Int) {
        val item = pokemonList[position]
        holder.onBind(item)
    }
}