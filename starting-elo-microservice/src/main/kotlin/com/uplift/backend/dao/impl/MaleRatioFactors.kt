package com.uplift.backend.dao.impl

import com.uplift.backend.dto.StartingELO
import com.uplift.backend.dao.intrface.Factors
import com.uplift.backend.utils.ageFactor
import com.uplift.backend.utils.generateRandom

// https://strengthlevel.com/strength-standards/male/kg

/**
 * This class is purposed with defining the logic of the functions which
 * analyses the body weight to lift ratios of male lifters and adds ELO
 * accordingly.
 *
 * @author David
 */
class MaleRatioFactors: Factors {
  
  
  /**
   * This method outlines how ELO is added to a male lifter
   * taking into account the body weight to bench ratio.
   *
   * @param currentELO the ELO before taking into account
   *                   the bench press.
   * @param startingELO the StartingELO object representing
   *                    a male lifters basic information.
   * @param currentWeight a male lifters current weight.
   *
   * @return the new ELO after taking into account this lift.
   */
  override fun addBenchFactors(currentELO: Int,
                               startingELO: StartingELO,
                               currentWeight: Float): Int {
  
    var newELO = currentELO
    val benchToBWRatio = startingELO.benchMax!! / currentWeight
  
    // println("bch ratio:  + $benchToBWRatio")
    
    newELO += when (benchToBWRatio) {
      in 0.0 .. 0.5 -> {
          generateRandom(10) // beginner
      }
      in 0.5 .. 0.8 -> {
        generateRandom(50) // novice
      }
      in 0.8 .. 0.9 -> {
        generateRandom(60)
      }
      in 0.9 .. 1.0 -> {
        generateRandom(70)
      }
      in 1.0 .. 1.1 -> {
        generateRandom(80)
      }
      in 1.1 .. 1.2 -> {
        generateRandom(90) // intermediate
      }
      in 1.2 .. 1.3 -> {
        generateRandom(100)
      }
      in 1.3 .. 1.4 -> {
        generateRandom(120)
      }
      in 1.4 .. 1.5 -> {
        generateRandom(140)
      }
      in 1.5 .. 1.7 -> {
        generateRandom(160) // advanced
      }
      in 1.7 .. 2.0 -> {
        generateRandom(190)
      }
      else -> {
        generateRandom(220) // elite
      }
    }
    
    return ageFactor(startingELO, newELO)
  }
  
  /**
   * This method outlines how ELO is added to a male lifter
   * taking into account the body weight to squat ratio.
   *
   * @param currentELO the ELO before taking into account
   *                   the squat.
   * @param startingELO the StartingELO object representing
   *                    a male lifters basic information.
   * @param currentWeight a male lifters current weight.
   *
   * @return the new ELO after taking into account this lift.
   */
  override fun addSquatFactors(currentELO: Int,
                               startingELO: StartingELO,
                               currentWeight: Float): Int {
  
    var newELO = currentELO
    val squatToBWRatio = startingELO.squatMax!! / currentWeight
  
    // println("sqr ratio:  + $squatToBWRatio")
    
    newELO += when (squatToBWRatio) {
      in 0.0 .. 0.8 -> {
        generateRandom(10) // beginner
      }
      in 0.9 .. 1.2 -> {
        generateRandom(30) // novice
      }
      in 1.2 .. 1.3 -> {
        generateRandom(30)
      }
      in 1.3 .. 1.4 -> {
        generateRandom(40)
      }
      in 1.4 .. 1.5 -> {
        generateRandom(50)
      }
      in 1.5 .. 1.6 -> {
        generateRandom(60) // intermediate
      }
      in 1.6 .. 1.7 -> {
        generateRandom(70)
      }
      in 1.7 .. 1.8 -> {
        generateRandom(80)
      }
      in 1.8 .. 1.9 -> {
        generateRandom(90)
      }
      in 1.9 .. 2.0 -> {
        generateRandom(95)
      }
      in 2.0 .. 2.1 -> {
        generateRandom(100)
      }
      in 2.1 .. 2.3 -> {
        generateRandom(120) // advanced
      }
      in 2.3 .. 2.5 -> {
        generateRandom(150)
      }
      in 2.5 .. 2.7 -> {
        generateRandom(180)
      }
      else -> {
        generateRandom(200) // elite
      }
    }
    
    return ageFactor(startingELO, newELO)
  }
  
  /**
   * This method outlines how ELO is added to a male lifter
   * taking into account the body weight to deadlift ratio.
   *
   * @param currentELO the ELO before taking into account
   *                    the deadlift.
   * @param startingELO the StartingELO object representing
   *                    a male lifters basic information.
   * @param currentWeight a male lifters current weight.
   *
   * @return the new ELO after taking into account this lift.
   */
  override fun addDeadLiftFactors(currentELO: Int,
                                  startingELO: StartingELO,
                                  currentWeight: Float): Int {
  
    var newELO = currentELO
    val deadLiftToBWRatio = startingELO.deadLiftMax!! / currentWeight
  
    // println("dd ratio:  + $deadLiftToBWRatio")
    
    newELO += when (deadLiftToBWRatio) {
      in 0.0 .. 0.9 -> {
        generateRandom(10) // beginner
      }
      in 0.9 .. 1.2 -> {
        generateRandom(30)
      }
      in 1.2 .. 1.3 -> {
        generateRandom(30)
      }
      in 1.3 .. 1.4 -> {
        generateRandom(40) // novice
      }
      in 1.4 .. 1.5 -> {
        generateRandom(50)
      }
      in 1.5 .. 1.6 -> {
        generateRandom(60)
      }
      in 1.6 .. 1.7 -> {
        generateRandom(70)
      }
      in 1.7 .. 1.8 -> {
        generateRandom(80)
      }
      in 1.8 .. 1.9 -> {
        generateRandom(90) // intermediate
      }
      in 1.9 .. 2.0 -> {
        generateRandom(95)
      }
      in 2.0 .. 2.1 -> {
        generateRandom(100)
      }
      in 2.1 .. 2.3 -> {
        generateRandom(120)
      }
      in 2.3 .. 2.5 -> {
        generateRandom(150)
      }
      in 2.5 .. 2.7 -> {
        generateRandom(180) // advanced
      }
      in 2.7 .. 2.9 -> {
        generateRandom(200)
      }
      in 2.9 .. 3.1 -> {
        generateRandom(220)
      }
      in 3.1 .. 3.25 -> {
        generateRandom(240)
      }
      else -> {
        generateRandom(260) // elite
      }
    }
  
    return ageFactor(startingELO, newELO)
    
  }
}