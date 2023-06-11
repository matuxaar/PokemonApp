package com.example.pokemonapp.ui.home

import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.pokemonapp.databinding.ItemPokemonBinding
import com.example.pokemonapp.domain.model.Pokemon

class PokemonHolder(
    private val binding: ItemPokemonBinding,
    private val itemClickListener: (Pokemon, ViewHolder) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(item: Pokemon) {
        with(binding) {
            textViewName.text = item.name
            textViewId.text = item.id

            item.typeofpokemon?.getOrNull(0).let { firstType ->
                textViewType3.text = firstType
                textViewType3.isVisible = firstType != null
            }

            item.typeofpokemon?.getOrNull(1).let { secondType ->
                textViewType2.text = secondType
                textViewType2.isVisible = secondType != null
            }

            item.typeofpokemon?.getOrNull(2).let { thirdType ->
                textViewType1.text = thirdType
                textViewType1.isVisible = thirdType != null
            }

            Glide.with(root.context)
                .load(item.imageUrl)
                .into(pokemonImageView)

            pokemonImageView.transitionName = item.name
            root.setOnClickListener{
                itemClickListener?.invoke(item, this@PokemonHolder)
            }
        }
    }
}