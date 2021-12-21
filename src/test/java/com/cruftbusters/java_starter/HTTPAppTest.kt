package com.cruftbusters.java_starter

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.http.*

class HTTPAppTest : FunSpec({
    startServer()
    test("Testing Hello World!") {
        val httpClient = HttpClient {
            defaultRequest {
                url.protocol = URLProtocol.HTTP
                url.host = "localhost"
                url.port = 8080
            }
        }
        httpClient.get<String>("/hello-world") shouldBe "Hello World!"
    }
})