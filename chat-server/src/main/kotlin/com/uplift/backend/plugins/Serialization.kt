package com.uplift.backend.plugins

import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*

/**
 * This method configures serialization in the server.
 */
fun Application.configureSerialization() {
   install(ContentNegotiation) {
       json()
   }
}
