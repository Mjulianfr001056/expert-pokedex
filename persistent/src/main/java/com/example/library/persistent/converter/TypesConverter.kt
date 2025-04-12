package com.example.library.persistent.converter

import androidx.room.TypeConverter

class TypesConverter {
    @TypeConverter
    fun fromTypes(types: Types): String {
        return types.name
    }

    @TypeConverter
    fun toTypes(types: String): Types {
        return Types.valueOf(types)
    }
}