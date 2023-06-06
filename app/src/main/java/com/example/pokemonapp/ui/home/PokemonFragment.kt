package com.example.pokemonapp.ui.home

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.pokemonapp.DaggerApp
import com.example.pokemonapp.R
import com.example.pokemonapp.databinding.FragmentPokemonBinding
import com.example.pokemonapp.di.viewmodel.ViewModelFactory
import com.example.pokemonapp.ui.generation.GenerationFragment
import com.example.pokemonapp.ui.search.SearchFragment

class PokemonFragment : Fragment() {

    lateinit var factory: ViewModelFactory
    private val viewModel: PokemonViewModel by viewModels { factory }
    private var _binding: FragmentPokemonBinding? = null

    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().applicationContext as DaggerApp).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPokemonBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

//    private fun showAllGen() {
//        val dialog = GenerationFragment()
//        dialog.show(childFragmentManager, "")
//    }
//
//    private fun showSearch() {
//        val dialog = SearchFragment()
//        dialog.show(childFragmentManager, "")
//    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}