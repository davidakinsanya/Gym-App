package dao.impl

import dto.StartingELO
import dao.intrface.Factors
import utils.ageFactor
import utils.generateRandom

class FemaleRatioFactors: Factors {
  
  companion object {
    private const val SQUAT_RATIO = 1
    private const val BENCH_RATIO = 0.5
    private const val DEADLIFT_RATIO = 1.5
  }
  
  override fun addBenchFactors(currentELO: Int,
                               startingELO: StartingELO,
                               currentWeight: Float): Int {
  
  
    var newELO = currentELO
    val benchToBWRatio = startingELO.benchMax / currentWeight
  
    newELO += if (benchToBWRatio >= 0.3 && benchToBWRatio < BENCH_RATIO) generateRandom(10)
    else if (benchToBWRatio >= 0.6 && benchToBWRatio < 0.7) generateRandom(30)
    else if (benchToBWRatio >= 0.7 && benchToBWRatio < 0.8) generateRandom(40)
    else if (benchToBWRatio >= 0.8 && benchToBWRatio < 0.9) generateRandom(50)
    else if (benchToBWRatio >= 0.9 && benchToBWRatio < 1) generateRandom(60)
    else generateRandom(100)
  
    return ageFactor(startingELO, newELO)
  }
  
  override fun addSquatFactors(currentELO: Int,
                               startingELO: StartingELO,
                               currentWeight: Float): Int {
  
    var newELO = currentELO
    val squatToBWRatio = startingELO.squatMax / currentWeight
  
    newELO += if (squatToBWRatio >= 0.8 && squatToBWRatio < SQUAT_RATIO) generateRandom(10)
    else if (squatToBWRatio >= 1.1 && squatToBWRatio < 1.2) generateRandom(30)
    else if (squatToBWRatio >= 1.2 && squatToBWRatio < 1.3) generateRandom(40)
    else if (squatToBWRatio >= 1.3 && squatToBWRatio < 1.4) generateRandom(50)
    else generateRandom(100)
  
    return ageFactor(startingELO, newELO)
    
  }
  
  override fun addDeadLiftFactors(currentELO: Int,
                                  startingELO: StartingELO,
                                  currentWeight: Float): Int {
  
    var newELO = currentELO
    val deadLiftToBWRatio = startingELO.deadLiftMax / currentWeight
  
    newELO += if (deadLiftToBWRatio >= 1.3 && deadLiftToBWRatio < DEADLIFT_RATIO) generateRandom(10)
    else if (deadLiftToBWRatio >= 1.4 && deadLiftToBWRatio < 1.5) generateRandom(30)
    else if (deadLiftToBWRatio >= 1.5 && deadLiftToBWRatio < 1.6) generateRandom(40)
    else if (deadLiftToBWRatio >= 1.6 && deadLiftToBWRatio < 1.7) generateRandom(50)
    else generateRandom(100)
  
    return ageFactor(startingELO, newELO)
  }
}