package com.example.pokemonapp.ui.pokemon.evolution

import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokemonapp.databinding.ItemPokemonBinding
import com.example.pokemonapp.domain.model.Pokemon
import com.example.pokemonapp.utils.ColorUtil

class EvolutionHolder(
    val binding: ItemPokemonBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(item: Pokemon) {
        with(binding) {
            textViewName.text = item.name
            textViewId.text = item.id

            val color = ColorUtil(itemView.context).getPokemonColor(item.typeOfPokemon)
            binding.root.background.colorFilter =
                PorterDuffColorFilter(color, PorterDuff.Mode.SRC_ATOP)

            item.typeOfPokemon?.getOrNull(0).let { firstType ->
                textViewType3.text = firstType
                textViewType3.isVisible = firstType != null
            }

            item.typeOfPokemon?.getOrNull(1).let { secondType ->
                textViewType2.text = secondType
                textViewType2.isVisible = secondType != null
            }

            item.typeOfPokemon?.getOrNull(2).let { thirdType ->
                textViewType1.text = thirdType
                textViewType1.isVisible = thirdType != null
            }

            Glide.with(binding.root.context)
                .load(item.imageUrl)
                .into(pokemonImageView)
        }
    }
}