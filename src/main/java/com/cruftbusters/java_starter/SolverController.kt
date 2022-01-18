package com.cruftbusters.java_starter

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.netty.*
import org.slf4j.Logger
import java.lang.RuntimeException

fun Application.solverController(
    validator: Validator,
    solver: Solver,
    logger: Logger
) {
    routing {
        get("/") {
            val equation = call.request.queryParameters["equation"]!!
            val userError = validator.validate(equation)
            if (userError.isNotEmpty()) {
                call.respond(HttpStatusCode.BadRequest, userError)
            } else try {
                call.respond(solver.solve(equation).toString())
            } catch (exception: Exception) {
                logger.error("There was an error while solving an equation", exception)
            }

        }
    }
}
