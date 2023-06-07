package com.example.pokemonapp.ui.generation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokemonapp.R
import com.example.pokemonapp.domain.model.Generation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class GenerationViewModel @Inject constructor(): ViewModel() {

    private val _listGen = MutableLiveData<List<Generation>>()
    val listGen: LiveData<List<Generation>> get() = _listGen

    fun getListGen(): LiveData<List<Generation>> {
        _listGen.value = listOf(
            Generation(id = 1, title = R.string.generation_item_1, image = R.drawable.gen1),
            Generation(id = 1, title = R.string.generation_item_2, image = R.drawable.gen2),
            Generation(id = 1, title = R.string.generation_item_3, image = R.drawable.gen3),
            Generation(id = 1, title = R.string.generation_item_4, image = R.drawable.gen4),
            Generation(id = 1, title = R.string.generation_item_5, image = R.drawable.gen5),
            Generation(id = 1, title = R.string.generation_item_6, image = R.drawable.gen6),
            Generation(id = 1, title = R.string.generation_item_7, image = R.drawable.gen7),
            Generation(id = 1, title = R.string.generation_item_8, image = R.drawable.gen8)
        )
        return listGen
    }
}