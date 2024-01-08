package utils

import dto.StartingELO
import kotlin.random.Random

fun ageFactor(startingELO: StartingELO, currentELO: Int): Int {
  var newELO = currentELO
  
  newELO += when (startingELO.age) {
    in 26..30 -> {
      generateRandom(20)
    }
    in 30..35 -> {
      generateRandom(30)
    }
    else -> {
      generateRandom(50)
    }
  }
  return newELO
}


fun generateRandom(number: Int): Int {
  return Random.nextInt(number-(number/2), number)
}
