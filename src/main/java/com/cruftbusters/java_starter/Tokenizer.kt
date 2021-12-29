package com.cruftbusters.java_starter

class Tokenizer {
    fun stringToToken(string: String) =
        string
            .replace(" ","")
            .split(operatorPattern)
            .filter { it.isNotEmpty() }

    private val operatorPattern =
        Regex(listOf("\\+", "-", "\\*", "/", "\\(", "\\)")
            .joinToString("|") { "(?<=$it)|(?=$it)" })
}
