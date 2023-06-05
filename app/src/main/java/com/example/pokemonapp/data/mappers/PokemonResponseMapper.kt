package com.example.pokemonapp.data.mappers

import com.example.pokemonapp.data.models.PokemonResponse
import com.example.pokemonapp.domain.model.Pokemon
import javax.inject.Inject

class PokemonResponseMapper @Inject constructor() {

    operator fun invoke(model: Pokemon): PokemonResponse = with(model) {
        return PokemonResponse(
            id = id,
            name = name,
            abilities = abilities,
            attack = attack,
            category = category,
            defense = defense,
            base_exp = base_exp,
            evolutions = evolutions,
            evolvedfrom = evolvedfrom,
            height = height,
            hp = hp,
            imageUrl = imageUrl,
            reason = reason,
            special_attack = special_attack,
            special_defense = special_defense,
            speed = speed,
            total = total,
            typeofpokemon = typeofpokemon,
            weakness = weakness,
            weight = weight,
            ydescription = ydescription
        )
    }
}