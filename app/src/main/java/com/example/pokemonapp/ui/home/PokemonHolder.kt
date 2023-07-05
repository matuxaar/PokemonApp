package com.example.pokemonapp.ui.home

import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.widget.ImageView
import androidx.core.view.isVisible
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
        setupListeners(item)
    }

    private fun setupListeners(item: Pokemon) {
        itemView.setOnClickListener {
            itemClickListener(item)
        }
    }

    private fun setType(item: Pokemon) {
        binding.textViewName.text = item.name
        binding.textViewId.text = item.id

        setColor(item)
        setFirstType(item)
        setSecondType(item)
        setThirdType(item)
    }

    private fun setColor(item: Pokemon) {
        val color = ColorUtil(itemView.context).getPokemonColor(item.typeOfPokemon)
        binding.root.background.colorFilter =
            PorterDuffColorFilter(color, PorterDuff.Mode.SRC_ATOP)
    }

    private fun setFirstType(item: Pokemon) {
        item.typeOfPokemon.getOrNull(0).let { type ->
            binding.textViewType1.text = type
            binding.textViewType1.isVisible = type != null
        }
    }

    private fun setSecondType(item: Pokemon) {
        item.typeOfPokemon.getOrNull(1).let { type ->
            binding.textViewType2.text = type
            binding.textViewType2.isVisible = type != null
        }
    }

    private fun setThirdType(item: Pokemon) {
        item.typeOfPokemon.getOrNull(2).let { type ->
            binding.textViewType3.text = type
            binding.textViewType3.isVisible = type != null
        }
    }

    private fun setImage(url: String, image: ImageView) {
        Glide.with(image)
            .load(url)
            .into(image)
    }
}