package com.example.pokemonapp.ui.pokemon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.example.pokemonapp.R
import com.example.pokemonapp.databinding.FragmentPokemonInfoBinding
import com.example.pokemonapp.di.viewmodel.ViewModelFactory
import com.example.pokemonapp.ui.pokemon.evolution.EvolutionFragment
import com.example.pokemonapp.ui.pokemon.info.InfoFragment

class PokemonInfoFragment : Fragment() {

    private val fragList = listOf(
        InfoFragment.newInstance(),
        EvolutionFragment.newInstance()
    )

    private lateinit var pokemonInfoAdapter: PokemonInfoAdapter
    private lateinit var viewPager: ViewPager2

    lateinit var factory: ViewModelFactory
    private val pokemonInfoViewModel: PokemonInfoViewModel by viewModels { factory }
    private var _binding: FragmentPokemonInfoBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pokemon_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        pokemonInfoAdapter = PokemonInfoAdapter(this, fragList)
        viewPager = view.findViewById(R.id.viewPager)
        viewPager.adapter = pokemonInfoAdapter

        val id = checkNotNull(arguments?.getString("id"))
        val name = checkNotNull(arguments?.getString("name"))

        _binding = FragmentPokemonInfoBinding.bind(view)
        binding?.imageView?.transitionName = name

        pokemonInfoViewModel.getPokemonById(id).observe(viewLifecycleOwner) { pokemonValue ->
            pokemonValue?.let { pokemon ->
                with(binding) {
                    textViewName.text = pokemon.name
                    textViewId.text = pokemon.id

                    pokemon.typeofpokemon?.getOrNull(0).let { firstType ->
                        textViewType3.text = firstType
                        textViewType3.isVisible = firstType != null
                    }

                    pokemon.typeofpokemon?.getOrNull(1).let { secondType ->
                        textViewType2.text = secondType
                        textViewType2.isVisible = secondType != null
                    }

                    pokemon.typeofpokemon?.getOrNull(2).let { thirdType ->
                        textViewType1.text = thirdType
                        textViewType1.isVisible = thirdType != null
                    }

                    Glide.with(binding.root.context)
                        .load(pokemon.imageUrl)
                        .into(imageView)
                }
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}