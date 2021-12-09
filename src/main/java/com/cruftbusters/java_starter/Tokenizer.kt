package com.cruftbusters.java_starter

class Tokenizer {
    fun stringToToken(string: String) =
        string.replace(" ","").split(operatorPattern)

    private val operatorPattern =
        Regex(listOf("\\+", "-", "\\*", "/")
            .joinToString("|") { "(?<=$it)|(?=$it)" })
}
