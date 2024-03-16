package com.backend.uplift.plugins

import com.backend.uplift.utils.TokenManager
import com.typesafe.config.ConfigFactory
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.config.*
import java.io.File

fun Application.configureAuth() {
  val file = File(System.getProperty("user.dir") + "/src/main/resources/auth.conf")
  val config = HoconApplicationConfig(ConfigFactory.parseFile(file))
  val tokenManger = TokenManager(config)
  
  install(Authentication) {
    jwt {
      verifier(tokenManger.verifyToken())
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