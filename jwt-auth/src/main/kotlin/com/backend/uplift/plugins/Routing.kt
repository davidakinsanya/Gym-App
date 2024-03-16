package com.backend.uplift.plugins

import com.backend.uplift.utils.TokenManager
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting(tokenManager: TokenManager) {
    routing {
        authenticate {
            
            get("/generate-token/{name}/{hash}") {
                call.respond(tokenManager.generateToken(call.parameters["name"]!!, call.parameters["hash"]!!))
            }
            
            get("/verify-token") {
                val principal = call.principal<JWTPrincipal>()
                val name = principal!!.payload.getClaim("name").asString()
                val hash = principal.payload.getClaim("hash").asString()
                
                if (name.isNotEmpty() && hash.isNotEmpty()) call.respond(HttpStatusCode(200, "OK"))
                else call.respond(HttpStatusCode(404, "USER NOT FOUND"))
            }
        }
    }
}
