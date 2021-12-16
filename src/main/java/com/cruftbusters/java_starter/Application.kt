package com.cruftbusters.java_starter

import java.io.*

fun main(args: Array<String>) {
    doTheWorkNow(System.`in`, System.out)
}

val solver = Solver(
    Tokenizer(),
    TokenToTree(),
    TreeSolver(),
)

fun doTheWorkNow(inputstream: InputStream, outputstream: OutputStream) {
    inputstream.bufferedReader().use { reader ->
        outputstream.writer().use { writer ->
            var equation = reader.readLine()
            while (equation != null) {
                writer.appendLine(
                    if (equation == "") "Input must be an equation."
                    else solver.solve(equation).toString()
                )
                writer.flush()
                equation = reader.readLine()
            }
        }
    }
}
