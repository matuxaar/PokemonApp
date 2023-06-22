package com.example.pokemonapp.ui.generation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapp.databinding.ItemGenerationBinding
import com.example.pokemonapp.domain.model.Generation

class GenerationAdapter(
    private val listGen: List<Generation>
): RecyclerView.Adapter<GenerationHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenerationHolder {
        val item = ItemGenerationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GenerationHolder(item)
    }

    override fun getItemCount(): Int = listGen.size

    override fun onBindViewHolder(holder: GenerationHolder, position: Int) {
        holder.onBind(listGen[position])
    }


}