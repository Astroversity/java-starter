package com.cruftbusters.java_starter

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    startServer(
        Solver(
            Tokenizer(),
            TokenToTree(),
            TreeSolver()
        )
    )
}

fun startServer(solver: Solver) {
    embeddedServer(Netty, port = 8080) {
        routing {
            get("/") {
                val equation = call.request.queryParameters["equation"]
                call.respond(solver.solve(equation!!).toString())
            }
        }
    }.start()
}