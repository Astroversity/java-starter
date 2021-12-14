package com.cruftbusters.java_starter

import java.io.*
import java.nio.charset.Charset

fun main(args: Array<String>) {
    while (true) {
        val line = readLine() ?: continue
        val result = Solver(
            Tokenizer(),
            TokenToTree(),
            TreeSolver(),
        )
            .solve(line)
        println(result)
    }
}

fun doTheWorkNow(inputstream: InputStream, outputstream: OutputStream) {
    val string = inputstream.bufferedReader().readText()
    val result = Solver(
        Tokenizer(),
        TokenToTree(),
        TreeSolver(),
    )
        .solve(string).toString()
    outputstream.writer().use {
        it.write(result)
    }
}
