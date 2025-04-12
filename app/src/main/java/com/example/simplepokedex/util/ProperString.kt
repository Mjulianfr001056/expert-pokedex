package com.example.simplepokedex.util

fun String.toProperString() : String{
    val words = this.split(" ")
    val properWords = words.map { it.lowercase().replaceFirstChar { ch -> ch.uppercase() } }
    val properString = properWords.joinToString(" ")
    return properString
}