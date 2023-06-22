package com.example.pokemonapp.data.database.converters

import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.ToJson

class StringToListConverter: JsonAdapter<List<String>>() {

    @FromJson
    override fun fromJson(reader: JsonReader): List<String>? {
        val stringList = mutableListOf<String>()
        reader.beginArray()
        while (reader.hasNext()) {
            stringList.add(reader.nextString())
        }
        reader.endArray()
        return stringList
    }

    @ToJson
    override fun toJson(writer: JsonWriter, value: List<String>?) {
        writer.beginArray()
        value?.forEach { writer.value(it) }
        writer.endArray()
    }
}