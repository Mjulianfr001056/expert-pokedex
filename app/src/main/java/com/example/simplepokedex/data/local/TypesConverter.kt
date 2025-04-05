package com.example.simplepokedex.data.local

import androidx.room.TypeConverter
import com.example.simplepokedex.data.stub.Types

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