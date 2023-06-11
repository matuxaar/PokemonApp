package com.example.pokemonapp.ui.generation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pokemonapp.DaggerApp
import com.example.pokemonapp.databinding.FragmentGenerationBinding
import com.example.pokemonapp.di.viewmodel.ViewModelFactory
import com.example.pokemonapp.domain.model.Generation
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class GenerationFragment : BottomSheetDialogFragment() {

    lateinit var factory: ViewModelFactory
    private val viewModel: GenerationViewModel by viewModels() //{ factory }
    private var _binding: FragmentGenerationBinding? = null

    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().applicationContext as DaggerApp).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGenerationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentGenerationBinding.bind(view)

        val layoutManager = GridLayoutManager(context, 2)
        binding?.recyclerView?.layoutManager = layoutManager

        viewModel.getListGeneration().observe(viewLifecycleOwner, Observer{
            val gens: List<Generation> = it
            binding.recyclerView.adapter = GenerationAdapter(gens)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}