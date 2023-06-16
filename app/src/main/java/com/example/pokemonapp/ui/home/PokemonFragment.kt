package com.example.pokemonapp.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.pokemonapp.DaggerApp
import com.example.pokemonapp.R
import com.example.pokemonapp.databinding.FragmentPokemonBinding
import com.example.pokemonapp.databinding.ItemPokemonBinding
import com.example.pokemonapp.di.viewmodel.ViewModelFactory
import com.example.pokemonapp.domain.model.Pokemon
import javax.inject.Inject

class PokemonFragment : Fragment() {

    @Inject
    lateinit var factory: ViewModelFactory
    private val viewModel: PokemonViewModel by viewModels { factory }
    private var _binding: FragmentPokemonBinding? = null
    private val binding get() = _binding!!

    private var pokemonId: String? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().applicationContext as DaggerApp).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPokemonBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()

        _binding = FragmentPokemonBinding.bind(view)

        val layoutManager = GridLayoutManager(context, 2)
        binding.recyclerView.layoutManager = layoutManager

        viewModel.pokemonLiveData.observe(viewLifecycleOwner, Observer { pokemons ->
            binding.recyclerView.adapter = PokemonAdapter(
                pokemonList = pokemons,
                itemClickListener = {pokemon ->
                    pokemonId = pokemon.id
                    setClick()
                }
            )

            if (pokemons.isNotEmpty())
                binding.progressBar.visibility = View.GONE
        })
    }

    private fun setClick() {
        findNavController().navigate(R.id.action_pokemonFragment_to_pokemonInfoFragment)
    }

    private fun initViewModel() {
        viewModel.getPokemonList()
        viewModel.getPoke()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}