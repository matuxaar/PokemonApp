package com.example.pokemonapp.data.mappers

import com.example.pokemonapp.data.models.PokemonResponse
import com.example.pokemonapp.domain.model.Pokemon
import javax.inject.Inject

class PokemonMapper @Inject constructor() {

    operator fun invoke(response: PokemonResponse): Pokemon = with(response) {
        return Pokemon(
            id = id.orEmpty(),
            name = name.orEmpty(),
            attack = attack ?: 0,
            category = category.orEmpty(),
            defense = defense ?: 0,
            baseExp = baseExp.orEmpty(),
            evolvedFrom = evolvedFrom.orEmpty(),
            height = height.orEmpty(),
            hp = hp ?: 0,
            imageUrl = imageUrl.orEmpty(),
            reason = reason.orEmpty(),
            specialAttack = specialAttack ?: 0,
            specialDefense = specialDefense ?: 0,
            speed = speed ?: 0,
            total = total ?: 0,
            weight = weight.orEmpty(),
            abilities = abilities?.map { it.toString() }?.toList() ?: mutableListOf(),
            evolutions = evolutions?.map { it.toString() }?.toList() ?: mutableListOf(),
            typeOfPokemon = typeOfPokemon?.map { it.toString() }?.toList() ?: mutableListOf(),
            weaknesses = weaknesses?.map { it.toString() }?.toList() ?: mutableListOf()
        )
    }
}