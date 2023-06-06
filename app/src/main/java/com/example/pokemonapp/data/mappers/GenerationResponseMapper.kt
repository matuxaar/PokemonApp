package com.example.pokemonapp.data.mappers

import com.example.pokemonapp.data.models.GenerationResponse
import com.example.pokemonapp.domain.model.Generation
import javax.inject.Inject

class GenerationResponseMapper @Inject constructor() {

    operator fun invoke(model: Generation): GenerationResponse = with(model) {
        return GenerationResponse(
            id = id,
            title = title,
            image = image
        )
    }
}