package com.uplift.backend.dao.impl

import com.uplift.backend.dto.StartingELO
import com.uplift.backend.dao.intrface.Factors
import com.uplift.backend.utils.ageFactor
import com.uplift.backend.utils.generateRandom

// https://strengthlevel.com/strength-standards/female/kg

/**
 * This class is purposed with defining the logic of the functions which
 * analyses the body weight to lift ratios of female lifters and adds ELO
 * accordingly.
 *
 * @author David
 */
class FemaleRatioFactors: Factors {
  
  /**
   * This method outlines how ELO is added to a female lifter
   * taking into account the body weight to bench ratio.
   *
   * @param currentELO the ELO before taking into account
   *                   the bench press.
   * @param startingELO the StartingELO object representing
   *                    a female lifters basic information.
   * @param currentWeight a female lifters current weight.
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
      in 0.0 .. 0.2 -> {
        generateRandom(10) // beginner
      }
      in 0.2 .. 0.3 -> {
        generateRandom(30)
      }
      in 0.3 .. 0.4 -> {
        generateRandom(30)
      }
      in 0.4 .. 0.5 -> {
        generateRandom(40)
      }
      in 0.5 .. 0.6 -> {
        generateRandom(50) // novice
      }
      in 0.6 .. 0.7 -> {
        generateRandom(60)
      }
      in 0.7 .. 0.8 -> {
        generateRandom(70)
      }
      in 0.8 .. 0.9 -> {
        generateRandom(80) // intermediate
      }
      in 0.9 .. 1.0 -> {
        generateRandom(60)
      }
      in 1.0 .. 1.1 -> {
        generateRandom(60)
      }
      in 1.1 .. 1.2 -> {
        generateRandom(60)
      }
      in 1.2 .. 1.3 -> {
        generateRandom(60) // advanced
      }
      in 1.3 .. 1.5 -> {
        generateRandom(90)
      }
      in 1.5 .. 1.7 -> {
        generateRandom(120)
      }
      else -> {
        generateRandom(150) // elite
      }
    }
  
    return ageFactor(startingELO, newELO)
  }
  
  /**
   * This method outlines how ELO is added to a female lifter
   * taking into account the body weight to squat ratio.
   *
   * @param currentELO the ELO before taking into account the squat.
   * @param startingELO the StartingELO object representing
   *                    a female lifters basic information.
   * @param currentWeight a female lifters current weight.
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
      in 0.0 .. 0.45 -> {
        generateRandom(10) // beginner
      }
      in 0.45 .. 0.55 -> {
        generateRandom(30)
      }
      in 0.55 .. 0.65 -> {
        generateRandom(40)
      }
      in 0.65 .. 0.75 -> {
        generateRandom(50)
      }
      in 0.75 .. 0.85 -> {
        generateRandom(60) // novice
      }
      in 0.85 .. 0.95 -> {
        generateRandom(70)
      }
      in 0.95 .. 1.0 -> {
        generateRandom(80)
      }
      in 1.0 .. 1.1 -> {
        generateRandom(90)
      }
      in 1.1 .. 1.2 -> {
        generateRandom(100)
      }
      in 1.2 .. 1.3 -> {
        generateRandom(110) // intermediate
      }
      in 1.1 .. 1.2 -> {
        generateRandom(60)
      }
      in 1.2 .. 1.3 -> {
        generateRandom(60) // advanced
      }
      in 1.3 .. 1.4 -> {
        generateRandom(90)
      }
      in 1.4 .. 1.5 -> {
        generateRandom(120)
      }
      in 1.4 .. 1.5 -> {
        generateRandom(120)
      }
      in 1.5 .. 1.6 -> {
        generateRandom(120)
      }
      in 1.6 .. 1.7 -> {
        generateRandom(120)
      }
      in 1.7 .. 1.8 -> {
        generateRandom(120)
      }
      in 1.8 .. 1.9 -> {
        generateRandom(120)
      }
      in 1.9 .. 2.0 -> {
        generateRandom(120)
      }
      in 2.1 .. 2.3 -> {
        generateRandom(150)
      }
      in 2.3 .. 2.5 -> {
        generateRandom(180)
      }
      else -> {
        generateRandom(200) // elite
      }
    }
  
    return ageFactor(startingELO, newELO)
    
  }
  
  /**
   * This method outlines how ELO is added to a female lifter
   * taking into account the body weight to deadlift ratio.
   *
   * @param currentELO the ELO before taking into account
   *                    the deadlift.
   * @param startingELO the StartingELO object representing
   *                    a female lifters basic information.
   * @param currentWeight a female lifters current weight.
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
      in 0.0 .. 0.6 -> {
        generateRandom(10) // beginner
      }
      in 0.6 .. 0.7 -> {
        generateRandom(30)
      }
      in 0.7 .. 0.8 -> {
        generateRandom(40)
      }
      in 0.8 .. 0.9 -> {
        generateRandom(50)
      }
      in 0.9 .. 1.0 -> {
        generateRandom(60)
      }
      in 1.0 .. 1.1 -> {
        generateRandom(70) // novice
      }
      in 1.1 .. 1.2 -> {
        generateRandom(80)
      }
      in 1.2 .. 1.3 -> {
        generateRandom(90)
      }
      in 1.3 .. 1.4 -> {
        generateRandom(100)
      }
      in 1.4 .. 1.5 -> {
        generateRandom(110)
      }
      in 1.5 .. 1.6 -> {
        generateRandom(120) // intermediate
      }
      in 1.6 .. 1.7 -> {
        generateRandom(130)
      }
      in 1.7 .. 1.8 -> {
        generateRandom(140)
      }
      in 1.8 .. 1.9 -> {
        generateRandom(150)
      }
      in 2.0 .. 2.1 -> {
        generateRandom(160)
      }
      in 2.1 .. 2.3 -> {
        generateRandom(190) // advanced
      }
      in 2.3 .. 2.5 -> {
        generateRandom(220)
      }
      in 2.5 .. 2.7 -> {
        generateRandom(250)
      }
      in 2.7 .. 2.9 -> {
        generateRandom(280)
      }
      else -> {
        generateRandom(310) // elite
      }
    }
  
    return ageFactor(startingELO, newELO)
  }
}