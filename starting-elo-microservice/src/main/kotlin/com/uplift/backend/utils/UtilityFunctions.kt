package com.uplift.backend.utils

import com.uplift.backend.dto.StartingELO
import kotlin.random.Random

/**
 * This function outlines how ELO is added taking into account the age is a new lifter.
 *
 * @param startingELO the StartingELO object representing
 *                    a new lifters basic information.
 * @param currentELO the ELO before taking into account
 *                   age.
 * @return the new ELO after taking into account the age.
 */
fun ageFactor(startingELO: StartingELO, currentELO: Int): Int {
  var newELO = currentELO
  
  newELO += when (startingELO.age) {
    in 0 .. 25 -> {
      generateRandom(5)
    }
    in 26..30 -> {
      generateRandom(60)
    }
    in 30..35 -> {
      generateRandom(90)
    }
    else -> {
      generateRandom(150)
    }
  }
  return newELO
}


/**
 * This function is purposed with generating a random number representing an increase in ELO.
 *
 * @param number an integer representing the rough increase in ELO.
 * @return a random number representing the ELO increase.
 */
fun generateRandom(number: Int): Int {
  return Random.nextInt(number-5, number)
}
