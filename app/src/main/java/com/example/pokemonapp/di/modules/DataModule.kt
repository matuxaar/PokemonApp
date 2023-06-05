package com.example.pokemonapp.di.modules

import com.example.pokemonapp.data.repositoriesimpl.PokemonRepositoryImpl
import com.example.pokemonapp.domain.repositories.PokemonRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface DataModule {

    @Binds
    @Singleton
    fun getPokemonRepository(impl: PokemonRepositoryImpl): PokemonRepository
}