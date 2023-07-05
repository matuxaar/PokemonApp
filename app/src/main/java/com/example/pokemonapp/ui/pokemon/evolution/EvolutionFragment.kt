package com.example.pokemonapp.ui.pokemon.evolution

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokemonapp.DaggerApp
import com.example.pokemonapp.R
import com.example.pokemonapp.databinding.FragmentEvolutionBinding
import com.example.pokemonapp.di.viewmodel.ViewModelFactory
import com.example.pokemonapp.ui.pokemon.PokemonInfoViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class EvolutionFragment : Fragment(R.layout.fragment_evolution) {

    @Inject
    lateinit var factory: ViewModelFactory
    private val viewModel: PokemonInfoViewModel by viewModels { factory }
    private var _binding: FragmentEvolutionBinding? = null
    private val args: EvolutionFragmentArgs by navArgs()
    private val binding get() = _binding!!

    private val adapter = EvolutionAdapter()
    private val pokemonId = ""

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().applicationContext as DaggerApp).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEvolutionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeLiveData()
        setupRecyclerView()
        setupAdapter()
    }

    private fun setupAdapter() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.pokemonListStateFlow.collectLatest { pokemonList ->
                adapter.setList(pokemonList)
                adapter.notifyDataSetChanged()

                if (pokemonList.isEmpty()) {
                    binding.textNonEvolving.visibility = View.VISIBLE
                } else {
                    binding.textNonEvolving.visibility = View.GONE
                }
            }
        }
    }

    private fun observeLiveData() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.pokemonSharedFlow.collect { pokemon ->
                pokemon?.let {
                    val evolutions = pokemon.evolutions ?: emptyList()
                    viewModel.getPokemonEvolutionsByIds(evolutions)
                }
            }
        }

        viewModel.getPokemonById(args.id)
    }

    private fun setupRecyclerView() {
        binding.recyclerViewEvolution.adapter = adapter
        binding.recyclerViewEvolution.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL,
            false
        )
    }

    private fun setClick(): Unit {
        val action = EvolutionFragmentDirections.actionEvolutionFragmentToPokemonInfoFragment(pokemonId)
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance(id: String) = EvolutionFragment().apply {
            arguments = Bundle().apply {
                putString("id", id)
            }
        }
    }
}