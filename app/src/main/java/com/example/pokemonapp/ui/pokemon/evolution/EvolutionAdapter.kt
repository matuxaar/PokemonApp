package com.example.pokemonapp.ui.pokemon.evolution

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapp.data.database.PokemonEntity
import com.example.pokemonapp.databinding.ItemPokemonBinding
import com.example.pokemonapp.domain.model.Pokemon

class EvolutionAdapter : RecyclerView.Adapter<EvolutionHolder>() {

    private val list = arrayListOf<Pokemon>()

    fun setList(list: List<PokemonEntity>?) {
        this.list.clear()
        this.list.addAll(list)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EvolutionHolder {
        val view = ItemPokemonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EvolutionHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: EvolutionHolder, position: Int) {
        val item = list[position]
        holder.onBind(item)
    }
}