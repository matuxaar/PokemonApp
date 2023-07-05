package com.example.pokemonapp.ui.pokemon.info

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.example.pokemonapp.DaggerApp
import com.example.pokemonapp.R
import com.example.pokemonapp.databinding.FragmentInfoBinding
import com.example.pokemonapp.di.viewmodel.ViewModelFactory
import com.example.pokemonapp.ui.pokemon.PokemonInfoViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


class InfoFragment : Fragment(R.layout.fragment_info) {

    @Inject
    lateinit var factory: ViewModelFactory
    private val pokemonInfoViewModel: PokemonInfoViewModel by viewModels { factory }
    private var _binding: FragmentInfoBinding? = null
    private val binding get() = _binding!!
    private val args: InfoFragmentArgs by navArgs()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().applicationContext as DaggerApp).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pokemonInfoViewModel.getPokemonById(args.id)

        setText()
        setProgressBar()
    }

    private fun setText() {
        viewLifecycleOwner.lifecycleScope.launch {
            pokemonInfoViewModel.pokemonSharedFlow.collect { pokemon ->
                with(binding) {
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
                }
            }
        }
    }

    private fun setProgressBar() {

        viewLifecycleOwner.lifecycleScope.launch {
            pokemonInfoViewModel.pokemonSharedFlow.collect { pokemon ->
                with(binding) {
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
        super.onDestroyView()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance(id: String) = InfoFragment().apply {
            arguments = Bundle().apply {
                putString("id", id)
            }
        }
    }
}