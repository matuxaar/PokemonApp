package com.example.pokemonapp.ui.pokemon

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.pokemonapp.ui.pokemon.evolution.EvolutionFragment
import com.example.pokemonapp.ui.pokemon.info.InfoFragment

class PokemonInfoAdapter(
    fragment: PokemonInfoFragment,
    private val pokemonId: String
) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = PAGE_COUNT

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> InfoFragment.newInstance(pokemonId)
            1 -> EvolutionFragment.newInstance(pokemonId)
            else -> throw IllegalStateException()
        }
    }

    companion object {
        private const val PAGE_COUNT = 2
    }
}