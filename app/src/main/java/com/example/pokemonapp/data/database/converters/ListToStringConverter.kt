package com.example.pokemonapp.data.database.converters

import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.ToJson

class ListToStringConverter: JsonAdapter<List<String>>() {

    @FromJson
    override fun fromJson(reader: JsonReader): List<String>? {
        throw UnsupportedOperationException("Parsing not supported")
    }

    @ToJson
    override fun toJson(writer: JsonWriter, value: List<String>?) {
        writer.value(value?.joinToString(","))
    }
}