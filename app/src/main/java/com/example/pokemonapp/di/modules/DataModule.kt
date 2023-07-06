package com.example.pokemonapp.di.modules

import com.example.pokemonapp.data.repositoriesimpl.PokemonRepositoryImpl
import com.example.pokemonapp.domain.repositories.PokemonRepository
import dagger.Binds
import dagger.Module

@Module
interface DataModule {

    @Binds
    fun getPokemonRepository(impl: PokemonRepositoryImpl): PokemonRepository
}