package com.example.pokemonapp.ui.pokemon.evolution

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokemonapp.DaggerApp
import com.example.pokemonapp.R
import com.example.pokemonapp.data.database.PokemonEntity
import com.example.pokemonapp.databinding.FragmentEvolutionBinding
import com.example.pokemonapp.databinding.FragmentPokemonInfoBinding
import com.example.pokemonapp.di.viewmodel.ViewModelFactory
import com.example.pokemonapp.domain.model.Pokemon
import com.example.pokemonapp.ui.pokemon.PokemonInfoViewModel
import javax.inject.Inject

class EvolutionFragment : Fragment(R.layout.fragment_evolution) {

    @Inject
    lateinit var factory: ViewModelFactory
    private val viewModel: PokemonInfoViewModel by viewModels { factory }
    private var _binding: FragmentEvolutionBinding? = null
    private val args: EvolutionFragmentArgs by navArgs()
    private val binding get() = _binding!!

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
        viewModel.getPokemonById(args.id)

        _binding = FragmentEvolutionBinding.bind(view)

        val recyclerView = binding.recyclerViewEvolution
        val layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager
        val adapter = EvolutionAdapter()
        recyclerView.adapter = adapter


        viewModel.pokemonLiveData.observe(viewLifecycleOwner) {
            it.let {
                val list = it.evolutions ?: emptyList()
                viewModel.getPokemonEvolutionsByIds(list)
                viewModel.pokemonListLiveData.observe(viewLifecycleOwner) {
                    val pokemons: List<Pokemon> = it
                    adapter.setList(pokemons)
                    adapter.notifyDataSetChanged()

                    if (pokemons.isEmpty()) {
                        binding?.textNonEvolving?.visibility = View.VISIBLE
                    }
                }
            }
        }

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