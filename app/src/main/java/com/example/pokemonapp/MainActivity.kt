package com.example.pokemonapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.pokemonapp.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        //(applicationContext as DaggerApp).appComponent.inject(this)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNav: BottomNavigationView = binding.bottomNavigation
        val navController = findNavController(R.id.mobile_host)
        bottomNav.setupWithNavController(navController)
        val badge = bottomNav.getOrCreateBadge(R.id.menuSearch)
        badge.backgroundColor = applicationContext.getColor(R.color.white)

        navController.addOnDestinationChangedListener {_, destination, _ ->
            badge.isVisible = true
            when(destination.id) {
                R.id.menuSearch -> {
                    bottomNav.isVisible = true
                }
                R.id.menuShowAllGen -> {
                    bottomNav.isVisible = true
                }
                else -> {
                    bottomNav.isVisible = true
                }
            }
        }
    }
}