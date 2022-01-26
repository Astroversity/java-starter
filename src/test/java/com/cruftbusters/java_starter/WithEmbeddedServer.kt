package com.cruftbusters.java_starter

import io.ktor.application.*
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import java.net.ServerSocket

suspend fun withEmbeddedServer(
    module: Application.() -> Unit,
    block: suspend (HttpClient) -> Unit,
) {
    val port = ServerSocket(0).run {
        val port = localPort
        close()
        port
    }

    embeddedServer(Netty, port = port, module = module).start()

    block(
        HttpClient {
            defaultRequest { setBaseUrl("http://localhost:$port") }
            install(JsonFeature)
        }
    )
}