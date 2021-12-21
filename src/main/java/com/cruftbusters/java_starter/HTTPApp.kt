package com.cruftbusters.java_starter

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    startServer()
}

fun startServer() {
    embeddedServer(Netty, port = 8080) {
        routing {
            get("/hello-world") {
                call.respond("Hello World!")
            }
        }
    }.start()
}