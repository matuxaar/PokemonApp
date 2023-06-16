package com.example.pokemonapp.ui.pokemon.info

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.pokemonapp.DaggerApp
import com.example.pokemonapp.R
import com.example.pokemonapp.databinding.FragmentInfoBinding
import com.example.pokemonapp.di.viewmodel.ViewModelFactory
import com.example.pokemonapp.ui.pokemon.PokemonInfoViewModel
import javax.inject.Inject


class InfoFragment : Fragment() {

    @Inject
    lateinit var factory: ViewModelFactory
    private val pokemonInfoViewModel: PokemonInfoViewModel by viewModels { factory }
    private var _binding: FragmentInfoBinding? = null
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().applicationContext as DaggerApp).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentInfoBinding.bind(view)

        pokemonInfoViewModel.pokemonLiveData.observe(viewLifecycleOwner) { pokemonValue ->
            pokemonValue?.let { pokemon ->
                binding?.apply {
                    textViewHeight.text = pokemon.height
                    textViewWeight.text = pokemon.weight
                    textViewBaseEXP.text = pokemon.baseExp

                    textViewHP.text = pokemon.hp.toString()
                    textViewAttack.text = pokemon.attack.toString()
                    textViewDefense.text = pokemon.defense.toString()
                    textViewSpAtk.text = pokemon.specialAttack.toString()
                    textViewSpDef.text = pokemon.specialDefense.toString()
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
        @JvmStatic
        fun newInstance(id: String?) = InfoFragment().apply {
            arguments = Bundle().apply {
                putString("id", id)
            }
        }
    }
}