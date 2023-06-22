package com.example.pokemonapp

import android.app.Application
import com.example.pokemonapp.di.ApplicationComponent
import com.example.pokemonapp.di.DaggerApplicationComponent


class DaggerApp : Application() {
    val appComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.factory().create(applicationContext)
    }
}