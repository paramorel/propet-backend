package com.example.propetbackend

import com.example.propetbackend.repository.NewsRepository
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.gson.gson
import io.ktor.http.ContentType
import io.ktor.response.respond
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    install(ContentNegotiation) {
        gson {
        }
    }

    routing {
        get("/news") {
            val repository = NewsRepository()
            val news = repository.getAllNews()
            call.respond(news)
        }

        get("/json/gson") {
            call.respond(mapOf("hello" to "world"))
        }
    }
}

