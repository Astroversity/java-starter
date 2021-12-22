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
        Solver(
            Tokenizer(),
            TokenToTree(),
            TreeSolver()
        )
    )
}

fun Application.solverController(
    solver: Solver
) {
    routing {
        get("/") {
            val equation = call.request.queryParameters["equation"]
            call.respond(solver.solve(equation!!).toString())
        }
    }
}
