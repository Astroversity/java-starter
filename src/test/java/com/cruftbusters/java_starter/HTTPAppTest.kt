package com.cruftbusters.java_starter

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.mockk.every
import io.mockk.mockk

class HTTPAppTest : FunSpec({
    startServer(mockk{
        every { solve("1+1") } returns 2
    })
    test("Testing Hello World!") {
        val httpClient = HttpClient {
            defaultRequest {
                url.protocol = URLProtocol.HTTP
                url.host = "localhost"
                url.port = 8080
            }
        }
        httpClient.get<String>("/") {
            parameter("equation","1+1")
        } shouldBe "2"
    }
})