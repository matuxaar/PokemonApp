package com.example.pokemonapp.di

import android.content.Context
import com.example.pokemonapp.di.modules.DataBaseModule
import com.example.pokemonapp.di.modules.DataModule
import com.example.pokemonapp.di.modules.NetworkModule
import com.example.pokemonapp.di.modules.ViewModelModule
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
}