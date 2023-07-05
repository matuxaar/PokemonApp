package com.example.pokemonapp.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.CombinedLoadStates
import androidx.paging.LoadState
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pokemonapp.DaggerApp
import com.example.pokemonapp.databinding.FragmentPokemonBinding
import com.example.pokemonapp.di.viewmodel.ViewModelFactory
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class PokemonFragment : Fragment() {

    @Inject
    lateinit var factory: ViewModelFactory
    private val viewModel: PokemonViewModel by viewModels { factory }
    private var _binding: FragmentPokemonBinding? = null
    private val binding get() = _binding!!
    private var pokemonId: String = ""


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
        //initViewModel()
        addPokemons()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val pokemonAdapter = PokemonAdapter { pokemon ->
            pokemonId = pokemon.id
            setClick()
        }

        binding.recyclerView.adapter = pokemonAdapter.withLoadStateFooter(PokemonLoadStateAdapter())
        pokemonAdapter.addLoadStateListener { state: CombinedLoadStates ->
            binding.recyclerView.isVisible = state.refresh != LoadState.Loading
            binding.progressBar.isVisible = state.refresh == LoadState.Loading
        }
        val layoutManager = GridLayoutManager(context, 2)
        binding.recyclerView.layoutManager = layoutManager

        observePokemons(pokemonAdapter)
    }

    private fun addPokemons() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.pokemonStateFlow.collect {
                viewModel.addPokemons(it)
            }
        }
    }

    private fun observePokemons(pokemonAdapter: PokemonAdapter) {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.pokemonFlow.collectLatest{ pokemonData ->
                pokemonAdapter.submitData(pokemonData)
            }
        }
    }


    private fun setClick() {
        val action = PokemonFragmentDirections.actionPokemonFragmentToPokemonInfoFragment(pokemonId)
        findNavController().navigate(action)
    }

//    private fun initViewModel() {
//        viewModel.getPokemonList()
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}