package com.backend.uplift.utils

import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.algorithms.Algorithm
import io.ktor.server.config.*
import java.util.*

/**
 * This class creates and verifies JWT Tokens.
 *
 * @param config a file containing configurations for the token.
 *
 * @author David.
 */
class TokenManager(private val config: HoconApplicationConfig) {
  private val audience = config.property("audience").getString()
  private val secret = config.property("secret").getString()
  private val issuer = config.property("issuer").getString()
  private val expirationDate = System.currentTimeMillis() + 60000
  
  /**
   * This method generates a JWT Token.
   *
   * @param name the name of the user.
   * @param hash the id of the user.
   *
   * @return a JWT token.
   */
  fun generateToken(name: String, hash: String): String {
    return JWT.create()
      .withAudience(audience)
      .withIssuer(issuer)
      .withClaim("name", name)
      .withClaim("hash", hash)
      .withExpiresAt(Date(expirationDate))
      .sign(Algorithm.HMAC256(secret))
  }
  
  /**
   * This method verifies a JWT Token.
   *
   * @return an object used to assess the token validity.
   */
  fun verifyToken(): JWTVerifier {
    return JWT.require(Algorithm.HMAC256(secret))
      .withAudience(audience)
      .withIssuer(issuer)
      .build()
  }
}