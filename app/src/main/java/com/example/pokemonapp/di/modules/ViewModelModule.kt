package com.example.pokemonapp.di.modules

import androidx.lifecycle.ViewModel
import com.example.pokemonapp.di.viewmodel.ViewModelKey
import com.example.pokemonapp.ui.generation.GenerationViewModel
import com.example.pokemonapp.ui.home.PokemonViewModel
import com.example.pokemonapp.ui.pokemon.PokemonInfoViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(PokemonViewModel::class)
    fun bindPokemonViewModel(viewModel: PokemonViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PokemonInfoViewModel::class)
    fun bindPokemonInfoViewModel(viewModel: PokemonInfoViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PokemonInfoViewModel::class)
    fun bindGenerationViewModel(viewModel: GenerationViewModel): ViewModel
}