package com.cruftbusters.java_starter

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.ktor.application.*
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.mockk.every
import io.mockk.mockk

class HTTPAppTest : FunSpec({
    embeddedServer(Netty, port = 8079) {
        module()
    }.start()
    test("Testing Hello World!") {
        val httpClient = HttpClient {
            defaultRequest {
                url.protocol = URLProtocol.HTTP
                url.host = "localhost"
                url.port = 8079
            }
        }
        httpClient.get<String>("/") {
            parameter("equation", "1+(2+(3+4))")
        } shouldBe "10"
    }
})