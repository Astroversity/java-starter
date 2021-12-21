package com.cruftbusters.java_starter

import java.io.*

fun main() {
    commandLineApplication(System.`in`, System.out)
}

val solver = Solver(
    Tokenizer(),
    TokenToTree(),
    TreeSolver(),
)

fun commandLineApplication(inputStream: InputStream, outputStream: OutputStream) {
    inputStream.bufferedReader().use { reader ->
        outputStream.writer().use { writer ->
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
