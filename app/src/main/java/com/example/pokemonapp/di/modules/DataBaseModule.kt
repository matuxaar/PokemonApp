package com.example.pokemonapp.di.modules

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.pokemonapp.data.database.AppDataBase
import com.example.pokemonapp.data.database.PokemonDao
import com.example.pokemonapp.di.viewmodel.ViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Provider
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Provides
    @Singleton
    fun provideDataBase(context: Context): AppDataBase {
        return Room.databaseBuilder(context, AppDataBase::class.java, DATABASE_NAME)
            .build()
    }

    @Provides
    fun provideViewModelFactory(
        viewModels: MutableMap<Class<out ViewModel>,
                @JvmSuppressWildcards Provider<ViewModel>>
    ):
            ViewModelProvider.Factory = ViewModelFactory(viewModels)

    @Provides
    @Singleton
    fun provideProductDao(db: AppDataBase): PokemonDao = db.getPokemonDao()

    companion object {
        private const val DATABASE_NAME = "database_name"
    }
}