package com.example.library.persistent.converter

import androidx.room.TypeConverter

class TypesConverter {
    @TypeConverter
    fun fromTypes(types: com.example.library.core.domain.model.Types): String {
        return types.name
    }

    @TypeConverter
    fun toTypes(types: String): com.example.library.core.domain.model.Types {
        return com.example.library.core.domain.model.Types.valueOf(types)
    }
}