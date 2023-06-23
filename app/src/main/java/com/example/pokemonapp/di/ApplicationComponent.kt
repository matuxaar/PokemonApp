package com.example.pokemonapp.di

//import com.example.pokemonapp.di.modules.DataModule
import android.content.Context
import com.example.pokemonapp.MainActivity
import com.example.pokemonapp.di.modules.DataBaseModule
import com.example.pokemonapp.di.modules.DataModule
import com.example.pokemonapp.di.modules.NetworkModule
import com.example.pokemonapp.di.modules.ViewModelModule
import com.example.pokemonapp.ui.generation.GenerationFragment
import com.example.pokemonapp.ui.home.PokemonFragment
import com.example.pokemonapp.ui.pokemon.PokemonInfoFragment
import com.example.pokemonapp.ui.pokemon.evolution.EvolutionFragment
import com.example.pokemonapp.ui.pokemon.info.InfoFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ViewModelModule::class, DataBaseModule::class, NetworkModule::class, DataModule::class])
interface ApplicationComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }

    fun inject(activity: MainActivity)
    fun inject(fragment: PokemonFragment)
    fun inject(fragment: PokemonInfoFragment)
    fun inject(fragment: InfoFragment)
    fun inject(fragment: EvolutionFragment)
    fun inject(fragment: GenerationFragment)
}