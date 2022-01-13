package com.cruftbusters.java_starter

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.netty.*
import org.slf4j.Logger
import java.lang.RuntimeException

fun Application.solverController(
    solver: Solver,
    logger: Logger
) {
    routing {
        get("/") {
            val equation = call.request.queryParameters["equation"]
            try {
                call.respond(solver.solve(equation!!).toString())
            } catch (exception: Exception) {
                logger.error("There was an error while solving an equation", exception)
            }
        }
    }
}
