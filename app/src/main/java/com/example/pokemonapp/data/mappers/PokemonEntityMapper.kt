package com.example.pokemonapp.data.mappers

import com.example.pokemonapp.data.database.PokemonEntity
import com.example.pokemonapp.domain.model.Pokemon
import javax.inject.Inject

class PokemonEntityMapper @Inject constructor() {

    operator fun invoke(
        pokemonEntity: PokemonEntity
    ): Pokemon = with(pokemonEntity) {
        return Pokemon(
            id = id,
            name = name,
            abilities = abilities,
            attack = attack,
            category = category,
            defense = defense,
            baseExp = baseExp,
            evolutions = evolutions,
            evolvedFrom = evolvedFrom,
            height = height,
            hp = hp,
            imageUrl = imageUrl,
            reason = reason,
            specialAttack = specialAttack,
            specialDefense = specialDefense,
            speed = speed,
            total = total,
            typeOfPokemon = typeOfPokemon,
            weaknesses = weaknesses,
            weight = weight
        )
    }
}