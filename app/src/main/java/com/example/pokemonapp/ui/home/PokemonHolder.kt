package com.example.pokemonapp.ui.home

import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.pokemonapp.databinding.ItemPokemonBinding
import com.example.pokemonapp.domain.model.Pokemon
import com.example.pokemonapp.utils.ColorUtil

class PokemonHolder(
    private val binding: ItemPokemonBinding,
    private val itemClickListener: (Pokemon) -> Unit
) : ViewHolder(binding.root) {

    fun onBind(item: Pokemon) {
        setType(item)
        setImage(item.imageUrl, binding.pokemonImageView)
        setUpListeners(item)
    }

    private fun setUpListeners(item: Pokemon) {
        itemView.setOnClickListener {
            itemClickListener(item)
        }
    }

    private fun setType(item: Pokemon) {
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
        }
    }

    private fun setImage(url: String, image: ImageView) {
        Glide.with(image)
            .load(url)
            .into(image)
    }
}