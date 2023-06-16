package com.example.pokemonapp.ui.pokemon.evolution

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokemonapp.DaggerApp
import com.example.pokemonapp.R
import com.example.pokemonapp.data.database.PokemonEntity
import com.example.pokemonapp.databinding.FragmentEvolutionBinding
import com.example.pokemonapp.di.viewmodel.ViewModelFactory
import com.example.pokemonapp.domain.model.Pokemon
import com.example.pokemonapp.ui.pokemon.PokemonInfoViewModel
import javax.inject.Inject

class EvolutionFragment : Fragment() {

    @Inject
    lateinit var factory: ViewModelFactory
    private val viewModel: PokemonInfoViewModel by viewModels { factory }
    private var _binding: FragmentEvolutionBinding? = null

    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().applicationContext as DaggerApp).appComponent.inject(this)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_evolution, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentEvolutionBinding.bind(view)

        val id = checkNotNull(arguments?.getString("id"))
        val recyclerView = binding.recyclerViewEvolution
        val layoutManager = LinearLayoutManager(context)
        recyclerView?.layoutManager = layoutManager
        val adapter = EvolutionAdapter()
        recyclerView?.adapter = adapter

//        viewModel.pokemonLiveData.observe(viewLifecycleOwner) { pokemonValue ->
//            pokemonValue.let { pokemon ->
//                viewModel.pokemonLiveData
//                    .observe(viewLifecycleOwner) {
//                        val pokemons: List<Pokemon>? = it
//                        adapter.setList(pokemons)
//                        adapter.notifyDataSetChanged()
//
//                        if (pokemons != null) {
//                            if (pokemons.isEmpty()) {
//                                binding.textNonEvolving.visibility = View.VISIBLE
//                            }
//                        }
//                    }
//            }
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance(id: String?) = EvolutionFragment().apply {
            arguments = Bundle().apply {
                putString("id", id)
            }
        }

    }
}