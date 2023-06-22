package com.example.pokemonapp.data.mappers

import com.example.pokemonapp.data.database.PokemonEntity
import com.example.pokemonapp.domain.model.Pokemon
import javax.inject.Inject

class PokemonToEntityMapper @Inject constructor() {

    operator fun invoke(
        pokemon: Pokemon
    ): PokemonEntity = with(pokemon) {
        return PokemonEntity(
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