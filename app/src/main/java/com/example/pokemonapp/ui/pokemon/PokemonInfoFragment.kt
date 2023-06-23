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
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.pokemonapp.DaggerApp
import com.example.pokemonapp.R
import com.example.pokemonapp.databinding.FragmentPokemonInfoBinding
import com.example.pokemonapp.di.viewmodel.ViewModelFactory
import com.example.pokemonapp.domain.model.Pokemon
import com.example.pokemonapp.utils.ColorUtil
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

        setupPager()

        pokemonInfoViewModel.pokemonLiveData.observe(viewLifecycleOwner) { pokemon ->
            setText(pokemon)
            setImage(pokemon.imageUrl, binding.imageView)
            setColor(pokemon, view)
            setTypes(pokemon)
        }
    }

    private fun setupPager() {
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
    }

    private fun setText(pokemon: Pokemon) {
        binding.textViewName.text = pokemon.name
        binding.textViewId.text = pokemon.id
    }

    private fun setColor(pokemon: Pokemon, view: View) {
        val color = ColorUtil(view.context).getPokemonColor(pokemon.typeOfPokemon)
        binding.appBar.setBackgroundColor(color)
        binding.toolbarLayout.contentScrim?.colorFilter =
            PorterDuffColorFilter(color, PorterDuff.Mode.SRC_ATOP)

        activity?.window?.statusBarColor =
            ColorUtil(view.context).getPokemonColor(pokemon.typeOfPokemon)
    }

    private fun setFirstType(pokemon: Pokemon) {
        pokemon.typeOfPokemon.getOrNull(0).let { type ->
            binding.textViewType1.text = type
            binding.textViewType1.isVisible = type != null
        }
    }

    private fun setSecondType(pokemon: Pokemon) {

        pokemon.typeOfPokemon.getOrNull(1).let { type ->
            binding.textViewType2.text = type
            binding.textViewType2.isVisible = type != null
        }

    }

    private fun setThirdType(pokemon: Pokemon) {
        pokemon.typeOfPokemon.getOrNull(2).let { type ->
            binding.textViewType3.text = type
            binding.textViewType3.isVisible = type != null
        }
    }

    private fun setTypes(pokemon: Pokemon) {
        setFirstType(pokemon)
        setSecondType(pokemon)
        setThirdType(pokemon)
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