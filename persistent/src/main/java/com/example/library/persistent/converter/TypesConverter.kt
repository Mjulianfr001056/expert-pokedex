package com.example.library.persistent.converter

import androidx.room.TypeConverter
import id.ac.stis.sipadu.config.Types

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