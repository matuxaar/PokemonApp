package com.example.pokemonapp.data.database.converters

import androidx.room.TypeConverter
import com.squareup.moshi.Moshi

class Converter {

    private val moshi = Moshi.Builder()
        .add(StringToListConverter())
        .add(ListToStringConverter())
        .build()

    @TypeConverter
    fun fromString(value: String?): List<String>? {
        if (value == null) null
        val listAdapter = moshi.adapter<List<String>>(List::class.java)
        return listAdapter.fromJson(value)
    }

    @TypeConverter
    fun fromList(list: List<String>?): String? {
        if (list == null) null
        val listAdapter = moshi.adapter<List<String>>(List::class.java)
        return listAdapter.toJson(list)
    }
}