package com.uplift.backend.utils

import com.uplift.backend.dto.StartingELO
import kotlin.random.Random

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


fun generateRandom(number: Int): Int {
  return Random.nextInt(number-5, number)
}
