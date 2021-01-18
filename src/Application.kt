package com.example.propetbackend

import com.example.propetbackend.database.DataBaseFactory
import com.example.propetbackend.repository.NewsRepository
import com.example.propetbackend.repository.dto.CreateNewsDto
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.gson.gson
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.response.respondText
import io.ktor.routing.*
import java.net.URI

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    install(ContentNegotiation) {
        gson {
            setPrettyPrinting()
            serializeNulls()
        }
    }

    val dbUri = URI(environment.config.property("db.jdbcUrl").getString())

    val username: String = dbUri.userInfo.split(":")[0]
    val password: String = dbUri.userInfo.split(":")[1]
    val dbUrl = ("jdbc:postgresql://${dbUri.host}:${dbUri.port}${dbUri.path}")

    DataBaseFactory(
        dbUrl = dbUrl,
        dbPassword = password,
        dbUser = username
    ).apply {
        init()
    }

    val repository = NewsRepository()

    routing {
        route("/news") {
            get {
                val news = repository.getAllNews()
                call.respond(news)
            }

            post {
                val news = call.receive<CreateNewsDto>()
                repository.addNews(news)
                call.respond(HttpStatusCode.OK)
            }

            delete{
                val id = call.request.queryParameters["id"]?.toLong()
                if(id == null){
                    call.respond(HttpStatusCode.NotFound)
                } else{
                    repository.deleteNews(id)
                    call.respond(HttpStatusCode.OK)
                }
            }
            put{
                repository.updateNews(call.receive())
                call.respond(HttpStatusCode.OK)
            }
        }
    }
}

