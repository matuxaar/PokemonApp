package com.example.pokemonapp.ui.pokemon.info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.pokemonapp.R
import com.example.pokemonapp.databinding.FragmentInfoBinding
import com.example.pokemonapp.di.viewmodel.ViewModelFactory
import com.example.pokemonapp.ui.pokemon.PokemonInfoViewModel


class InfoFragment : Fragment() {

    lateinit var factory: ViewModelFactory
    private val pokemonInfoViewModel: PokemonInfoViewModel by viewModels { factory }
    private var _binding: FragmentInfoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = checkNotNull(arguments?.getString("id"))

        _binding = FragmentInfoBinding.bind(view)

        pokemonInfoViewModel.getPokemonById(id).observe(viewLifecycleOwner) { pokemonValue ->
            pokemonValue?.let { pokemon ->
                binding?.apply {
                    textViewHeight.text = pokemon.height
                    textViewWeight.text = pokemon.weight
                    textViewBaseEXP.text = pokemon.base_exp

                    textViewHP.text = pokemon.hp.toString()
                    textViewAttack.text = pokemon.attack.toString()
                    textViewDefense.text = pokemon.defense.toString()
                    textViewSpAtk.text = pokemon.special_attack.toString()
                    textViewSpDef.text = pokemon.special_defense.toString()
                    textViewSpeed.text = pokemon.speed.toString()
                    textViewTotal.text = pokemon.total.toString()

                    progressBarHp.progress = pokemon.hp ?: 0
                    progressBarAttack.progress = pokemon.hp ?: 0
                    progressBarDefense.progress = pokemon.hp ?: 0
                    progressBarSpAtk.progress = pokemon.hp ?: 0
                    progressBarSpDef.progress = pokemon.hp ?: 0
                    progressBarSpeed.progress = pokemon.hp ?: 0
                    progressBarTotal.progress = pokemon.hp ?: 0
                }
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    companion object {
        fun newInstance() = InfoFragment()
    }
}