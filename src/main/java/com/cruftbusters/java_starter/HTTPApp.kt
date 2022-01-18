package com.cruftbusters.java_starter

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.netty.*

fun main(args: Array<String>) {
    EngineMain.main(args)
}

fun Application.module() {
    solverController(
        Validator(),
        Solver(
            Tokenizer(),
            TokenToTree(),
            TreeSolver()
        ),
        log
    )
}