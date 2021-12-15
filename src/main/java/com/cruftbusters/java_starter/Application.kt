package com.cruftbusters.java_starter

import java.io.*

fun main(args: Array<String>) {
    doTheWorkNow(System.`in`, System.out)
}

fun doTheWorkNow(inputstream: InputStream, outputstream: OutputStream) {
    val equations = inputstream.reader().use {
        it.readText().split('\n')
    }
    for (equation in equations) {
        val result = Solver(
            Tokenizer(),
            TokenToTree(),
            TreeSolver(),
        ).solve(equation).toString()
        outputstream.writer().use {
            it.appendLine(result)
        }
    }
    outputstream.close()
}
