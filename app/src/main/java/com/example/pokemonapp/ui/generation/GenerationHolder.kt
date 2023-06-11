package com.example.pokemonapp.ui.generation

import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapp.databinding.ItemGenerationBinding
import com.example.pokemonapp.domain.model.Generation

class GenerationHolder(
    private val binding: ItemGenerationBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(item: Generation) {
        with(binding) {
            textViewTitle.text = itemView.context.getString(item.title)
            generationImageView.setImageResource(item.image)
        }
    }
}