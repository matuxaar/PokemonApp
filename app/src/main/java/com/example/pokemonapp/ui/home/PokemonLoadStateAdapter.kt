package com.example.pokemonapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapp.databinding.PartDefaultLoadStateBinding

class PokemonLoadStateAdapter() : LoadStateAdapter<PokemonLoadStateAdapter.ProgressViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): ProgressViewHolder {
        val item = PartDefaultLoadStateBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProgressViewHolder(item)
    }

    override fun onBindViewHolder(holder: ProgressViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }


    class ProgressViewHolder(
        private val binding: PartDefaultLoadStateBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(loadState: LoadState) = with(binding) {
            progressBar.isVisible = loadState is LoadState.Loading
        }
    }

}