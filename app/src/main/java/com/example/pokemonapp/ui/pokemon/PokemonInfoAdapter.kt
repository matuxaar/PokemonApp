package com.example.pokemonapp.ui.pokemon

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapp.databinding.FragmentPokemonInfoBinding
import com.example.pokemonapp.databinding.ItemPokemonBinding
import com.example.pokemonapp.domain.model.Pokemon

class PokemonInfoAdapter(
    private val list: List<Pokemon>,
    private val itemClickListener: (Pokemon, RecyclerView.ViewHolder) -> Unit
) : RecyclerView.Adapter<PokemonInfoHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonInfoHolder {
        TODO()
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: PokemonInfoHolder, position: Int) {
        TODO("Not yet implemented")
    }
}