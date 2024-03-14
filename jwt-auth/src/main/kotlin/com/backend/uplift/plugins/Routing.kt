package com.backend.uplift.plugins

import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    install(Routing) {
        get("/") {
            println("Hello World!")
        }
    }
}
