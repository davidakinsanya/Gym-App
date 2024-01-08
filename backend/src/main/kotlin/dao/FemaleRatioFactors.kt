package dao

private const val SQUAT_RATIO = 1
private const val BENCH_RATIO = 0.5
private const val DEADLIFT_RATIO = 1.5

// https://www.boxrox.com/how-strong-should-you-be-athlete-level/

fun addBenchFactorsFemale(currentELO: Int,
                          startingELO: StartingELO,
                          currentWeight: Float): Int {
  
  var newELO = currentELO
  val benchToBWRatio = startingELO.benchMax / currentWeight
  
  newELO += if (benchToBWRatio >= 0.3 && benchToBWRatio < BENCH_RATIO) 1
  else if (benchToBWRatio >= 0.6 && benchToBWRatio < 0.7) 3
  else if (benchToBWRatio >= 0.7 && benchToBWRatio < 0.8) 6
  else if (benchToBWRatio >= 0.8 && benchToBWRatio < 0.9) 4
  else if (benchToBWRatio >= 0.9 && benchToBWRatio < 1) 5
  else 10
  
  return newELO
}

fun addSquatFactorsFemale(currentELO: Int,
                          startingELO: StartingELO,
                          currentWeight: Float): Int {
  
  var newELO = currentELO
  val squatToBWRatio = startingELO.squatMax / currentWeight
  
  newELO += if (squatToBWRatio >= 0.8 && squatToBWRatio < SQUAT_RATIO) 1
  else if (squatToBWRatio >= 1.1 && squatToBWRatio < 1.2) 3
  else if (squatToBWRatio >= 1.2 && squatToBWRatio < 1.3) 4
  else if (squatToBWRatio >= 1.3 && squatToBWRatio < 1.4) 5
  else 10
  
  return newELO
}

fun addDeadLiftFactorsFemale(currentELO: Int,
                             startingELO: StartingELO,
                             currentWeight: Float): Int {
  
  var newELO = currentELO
  val deadLiftToBWRatio = startingELO.deadLiftMax / currentWeight
  
  newELO += if (deadLiftToBWRatio >= 1.3 && deadLiftToBWRatio < DEADLIFT_RATIO) 1
  else if (deadLiftToBWRatio >= 1.4 && deadLiftToBWRatio < 1.5) 3
  else if (deadLiftToBWRatio >= 1.5 && deadLiftToBWRatio < 1.6) 4
  else if (deadLiftToBWRatio >= 1.6 && deadLiftToBWRatio < 1.7) 5
  else 10
  
  return newELO
}