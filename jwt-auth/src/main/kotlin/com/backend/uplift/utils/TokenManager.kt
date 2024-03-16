package com.backend.uplift.utils

import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.algorithms.Algorithm
import io.ktor.server.config.*
import java.util.*

class TokenManager(private val config: HoconApplicationConfig) {
  private val audience = config.property("audience").getString()
  private val secret = config.property("secret").getString()
  private val issuer = config.property("issuer").getString()
  private val expirationDate = System.currentTimeMillis() + 60000
  
  fun generateToken(name: String, hash: String): String {
    return JWT.create()
      .withAudience(audience)
      .withIssuer(issuer)
      .withClaim("name", name)
      .withClaim("hash", hash)
      .withExpiresAt(Date(expirationDate))
      .sign(Algorithm.HMAC256(secret))
  }
  
  fun verifyToken(): JWTVerifier {
    return JWT.require(Algorithm.HMAC256(secret))
      .withAudience(audience)
      .withIssuer(issuer)
      .build()
  }
}