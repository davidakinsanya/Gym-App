package dao

private val SQUAT_RATIO = 1.5
private val BENCH_RATIO = 1
private val DEADLIFT_RATIO = 2

fun addBenchFactors(startingELO: Int,
                    benchMax: Float,
                    currentWeight: Float): Int {
  
  var newELO = startingELO
  val benchToBWRatio = benchMax / currentWeight
  
  newELO += if (benchToBWRatio >= 0.8 && benchToBWRatio < BENCH_RATIO) 1
  else if (benchToBWRatio >= 1.1 && benchToBWRatio < 1.2) 3
  else if (benchToBWRatio >= 1.3 && benchToBWRatio < 1.3) 6
  else if (benchToBWRatio >= 1.3 && benchToBWRatio < 1.4) 4
  else if (benchToBWRatio >= 1.4 && benchToBWRatio < 1.5) 5
  else 10
  
  return newELO
}

fun addSquatFactors(startingELO: Int,
                      squatMax: Float,
                      currentWeight: Float): Int {
  
  var newELO = startingELO
  val squatToBWRatio = squatMax / currentWeight
  
  newELO += if (squatToBWRatio >= 1.3 && squatToBWRatio < SQUAT_RATIO) 1
  else if (squatToBWRatio >= 1.6 && squatToBWRatio < 1.7) 3
  else if (squatToBWRatio >= 1.7 && squatToBWRatio < 1.8) 4
  else if (squatToBWRatio >= 1.8 && squatToBWRatio < 1.9) 5
  else 10
  
  return newELO
}

fun addDeadLiftFactors(startingELO: Int,
                    deadLiftMax: Float,
                    currentWeight: Float): Int {
  
  var newELO = startingELO
  val deadLiftToBWRatio = deadLiftMax / currentWeight
  
  newELO += if (deadLiftToBWRatio >= 1.9 && deadLiftToBWRatio < DEADLIFT_RATIO) 1
  else if (deadLiftToBWRatio >= 2.1 && deadLiftToBWRatio < 2.2) 3
  else if (deadLiftToBWRatio >= 2.3 && deadLiftToBWRatio < 2.4) 4
  else if (deadLiftToBWRatio >= 2.4 && deadLiftToBWRatio < 2.5) 5
  else 10
  
  return newELO
}