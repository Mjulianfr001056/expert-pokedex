package com.example.library.persistent.converter

import androidx.room.TypeConverter
import kotlinx.serialization.json.Json

class TypesConverter {
    @TypeConverter
    fun fromTypes(types: Types): String {
        return types.name
    }

    @TypeConverter
    fun toTypes(types: String): Types {
        return Types.valueOf(types)
    }

    @TypeConverter
    fun fromTypesList(list: List<Types>): String {
        return Json.encodeToString(list)
    }

    @TypeConverter
    fun toTypesList(data: String): List<Types> {
        return Json.decodeFromString(data)
    }
}