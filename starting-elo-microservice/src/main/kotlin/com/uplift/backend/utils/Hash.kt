package com.uplift.backend.utils

import java.security.MessageDigest

/**
 * This class generates hash codes to generate anonymous lifter ID's.
 *
 * @author David
 */
class Hash {
  
  companion object {
    /**
     * This function generate a sha-256 hash code.
     *
     * @return a hash code.
     */
    fun hash(): String {
      val bytes = this.toString().toByteArray()
      val md = MessageDigest.getInstance("SHA-256")
      val digest = md.digest(bytes)
      return digest.fold("") { str, it -> str + "%02x".format(it) }
    }
  }
}