package com.backend.uplift.plugins

import com.backend.uplift.utils.TokenManager
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.config.*

/**
 * This method configures authentication in the server.
 */
fun Application.configureAuth(tokenManager: TokenManager, config: HoconApplicationConfig) {
  install(Authentication) {
    jwt {
      verifier(tokenManager.verifyToken())
      realm = config.property("realm").getString()
      
      validate { jwtCredential ->
        if (jwtCredential.payload.getClaim("name").asString().isNotEmpty())
          JWTPrincipal(jwtCredential.payload)
        else
          null
      }
    }
  }
  
}