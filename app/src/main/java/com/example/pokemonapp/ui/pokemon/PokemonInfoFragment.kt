package com.example.pokemonapp.ui.pokemon

import android.content.Context
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.example.pokemonapp.DaggerApp
import com.example.pokemonapp.R
import com.example.pokemonapp.databinding.FragmentPokemonInfoBinding
import com.example.pokemonapp.di.viewmodel.ViewModelFactory
import com.example.pokemonapp.domain.model.Pokemon
import com.example.pokemonapp.ui.pokemon.evolution.EvolutionFragment
import com.example.pokemonapp.ui.pokemon.info.InfoFragment
import com.example.pokemonapp.utils.ColorUtil
import javax.inject.Inject

class PokemonInfoFragment : Fragment() {

    private val fragList = listOf(
        InfoFragment.newInstance(ID),
        EvolutionFragment.newInstance(ID)
    )

    private lateinit var pokemonInfoAdapter: PokemonInfoAdapter
    private lateinit var viewPager: ViewPager2

    @Inject
    lateinit var factory: ViewModelFactory
    private val pokemonInfoViewModel: PokemonInfoViewModel by viewModels { factory }
    private var _binding: FragmentPokemonInfoBinding? = null
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().applicationContext as DaggerApp).appComponent.inject(this)
    }

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

        _binding = FragmentPokemonInfoBinding.bind(view)

        pokemonInfoViewModel.pokemonLiveData.observe(viewLifecycleOwner) { pokemonValue ->
            pokemonValue?.let { pokemon ->
                with(binding) {
                    textViewName.text = pokemon.name
                    textViewId.text = pokemon.id

                    pokemonInfoViewModel.getPokemonById(pokemon.id)

                    val color = ColorUtil(view.context).getPokemonColor(pokemon.typeOfPokemon)
                    with(binding) {
                        appBar.setBackgroundColor(color)
                        toolbarLatout.contentScrim?.colorFilter =
                            PorterDuffColorFilter(color, PorterDuff.Mode.SRC_ATOP)
                    }
                    activity?.window?.statusBarColor =
                        ColorUtil(view.context).getPokemonColor(pokemon.typeOfPokemon)

                    pokemon.typeOfPokemon.getOrNull(0).let { firstType ->
                        textViewType3.text = firstType
                        textViewType3.isVisible = firstType != null
                    }

                    pokemon.typeOfPokemon.getOrNull(1).let { secondType ->
                        textViewType2.text = secondType
                        textViewType2.isVisible = secondType != null
                    }

                    pokemon.typeOfPokemon.getOrNull(2).let { thirdType ->
                        textViewType1.text = thirdType
                        textViewType1.isVisible = thirdType != null
                    }

                    setImage(pokemon.imageUrl, imageView)
                }
            }
        }
    }

    private fun setImage(url: String, image: ImageView) {
        Glide.with(image)
            .load(url)
            .centerCrop()
            .into(image)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val ID = "ID"
        private const val NAME = "NAME"
    }

}