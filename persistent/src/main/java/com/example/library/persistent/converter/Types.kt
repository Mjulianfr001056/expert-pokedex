package com.example.library.persistent.converter

import androidx.compose.ui.graphics.Color

enum class Types {
    NORMAL,
    FIRE,
    WATER,
    ELECTRIC,
    GRASS,
    ICE,
    FIGHTING,
    POISON,
    GROUND,
    FLYING,
    PSYCHIC,
    BUG,
    ROCK,
    GHOST,
    DRAGON,
    DARK,
    STEEL,
    FAIRY,
    UNKNOWN,
}

fun Types.getBadgeColor() : Pair<Color, Color> {
    return when(this) {
        Types.NORMAL -> Pair(Color(0xFFA4ACAF), Color(0xFFA4ACAF))
        Types.FIRE -> Pair(Color(0xFFFD7D24), Color(0xFFFD7D24))
        Types.WATER -> Pair(Color(0xFF4592C4), Color(0xFF4592C4))
        Types.ELECTRIC -> Pair(Color(0xFFFBC02D), Color(0xFFFBC02D))
        Types.GRASS -> Pair(Color(0xFF9CCC65), Color(0xFF9CCC65))
        Types.ICE -> Pair(Color(0xFF51C4E7), Color(0xFF51C4E7))
        Types.FIGHTING -> Pair(Color(0xFFD56723), Color(0xFFD56723))
        Types.POISON -> Pair(Color(0xFFB97FC9), Color(0xFFB97FC9))
        Types.GROUND -> Pair(Color(0xFFF7DE3F), Color(0xFFAB9842))
        Types.FLYING -> Pair(Color(0xFF3DC7EF), Color(0xFFBDB9B8))
        Types.PSYCHIC -> Pair(Color(0xFFF366B9), Color(0xFFF366B9))
        Types.BUG -> Pair(Color(0xFFA6B91A), Color(0xFFA6B91A))
        Types.ROCK -> Pair(Color(0xFFA38C21), Color(0xFFA38C21))
        Types.GHOST -> Pair(Color(0xFF735797), Color(0xFF735797))
        Types.DRAGON -> Pair(Color(0xFF53A4CF), Color(0xFFF16E57))
        Types.DARK -> Pair(Color(0xFF705746), Color(0xFF705746))
        Types.STEEL -> Pair(Color(0xFFB7B7CE), Color(0xFFB7B7CE))
        Types.FAIRY -> Pair(Color(0xFFEE99AC), Color(0xFFEE99AC))
        Types.UNKNOWN -> Pair(Color(0xFF000000), Color(0xFF000000))
    }
}

fun Types.getTextColor() : Color {
    return when(this) {
        Types.NORMAL -> Color(0xFF000000)
        Types.FIRE -> Color(0xFFFFFFFF)
        Types.WATER -> Color(0xFFFFFFFF)
        Types.ELECTRIC -> Color(0xFF000000)
        Types.GRASS -> Color(0xFF000000)
        Types.ICE -> Color(0xFF000000)
        Types.FIGHTING -> Color(0xFFFFFFFF)
        Types.POISON -> Color(0xFFFFFFFF)
        Types.GROUND -> Color(0xFF000000)
        Types.FLYING -> Color(0xFF000000)
        Types.PSYCHIC -> Color(0xFFFFFFFF)
        Types.BUG -> Color(0xFFFFFFFF)
        Types.ROCK -> Color(0xFFFFFFFF)
        Types.GHOST -> Color(0xFFFFFFFF)
        Types.DRAGON -> Color(0xFFFFFFFF)
        Types.DARK -> Color(0xFFFFFFFF)
        Types.STEEL -> Color(0xFF000000)
        Types.FAIRY -> Color(0xFF000000)
        Types.UNKNOWN -> Color(0xFFFFFFFF)
    }
}