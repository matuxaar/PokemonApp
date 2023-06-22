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
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.example.pokemonapp.DaggerApp
import com.example.pokemonapp.R
import com.example.pokemonapp.databinding.FragmentPokemonInfoBinding
import com.example.pokemonapp.di.viewmodel.ViewModelFactory
import com.example.pokemonapp.ui.home.PokemonFragmentDirections
import com.example.pokemonapp.ui.pokemon.evolution.EvolutionFragment
import com.example.pokemonapp.ui.pokemon.info.InfoFragment
import com.example.pokemonapp.utils.ColorUtil
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import javax.inject.Inject

class PokemonInfoFragment : Fragment(R.layout.fragment_pokemon_info) {

    @Inject
    lateinit var factory: ViewModelFactory
    private val pokemonInfoViewModel: PokemonInfoViewModel by viewModels { factory }
    private var _binding: FragmentPokemonInfoBinding? = null
    private val binding get() = _binding!!
    private val args: PokemonInfoFragmentArgs by navArgs()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().applicationContext as DaggerApp).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPokemonInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pokemonInfoViewModel.getPokemonById(args.id)

        val pager = binding.viewPager
        val tabLayout = binding.tabLayout
        val adapter = PokemonInfoAdapter(this, args.id)
        pager.adapter = adapter

        TabLayoutMediator(tabLayout, pager) { tab, pos ->
            tab.text = when (pos) {
                0 -> getString(R.string.tab_1)
                1 -> getString(R.string.tab_2)
                else -> getString(R.string.tab_1)
            }
        }.attach()

        pokemonInfoViewModel.pokemonLiveData.observe(viewLifecycleOwner) { pokemon ->

            with(binding) {
                textViewName.text = pokemon.name
                textViewId.text = pokemon.id

                setImage(pokemon.imageUrl, imageView)

                val color = ColorUtil(view.context).getPokemonColor(pokemon.typeOfPokemon)
                appBar?.setBackgroundColor(color)
                toolbarLayout?.contentScrim?.colorFilter =
                    PorterDuffColorFilter(color, PorterDuff.Mode.SRC_ATOP)

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
}