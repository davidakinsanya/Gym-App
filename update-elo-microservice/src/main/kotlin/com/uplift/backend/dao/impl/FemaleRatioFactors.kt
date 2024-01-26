package com.uplift.backend.dao.impl

import com.uplift.backend.dao.intrface.Factors

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
   * This method outlines how ELO is added taking into account the body weight
   * to bench ratio.
   *
   * @param currentELO the ELO before taking into account the bench press.
   * @param benchMax a female lifters bench max for the week.
   * @param listOfBench a female lifters bench press numbers over the past three weeks.
   * @param currentWeight a female lifters current weight.
   *
   * @return a female lifters ELO after considering their bench.
   */
  override fun addBenchFactors(currentELO: Int,
                               benchMax: Float,
                               listOfBench: List<Float>,
                               currentWeight: Float): Int {
  
    var newELO = currentELO
    val threeWeekAverage = listOfBench.sum() / listOfBench.size
    val benchToBWRatio = benchMax / currentWeight
  
    newELO += when (benchToBWRatio) {
    
      in 0.0 .. 0.2 -> {
        1  // beginner
      }
      in 0.2 .. 0.6 -> {
        2  // novice
      }
      in 0.6 .. 0.9 -> {
        3  // intermediate
      }
      in 0.9 .. 1.3 -> {
        4  // advanced
      } else -> {
        5  // elite
      }
    
    }
  
    return 0
    
  }
  
  /**
   * This method outlines how ELO is added taking into account the body weight
   * to squat ratio.
   *
   * @param currentELO the ELO before taking into account the squat.
   * @param squatMax a female lifters squat max for the week.
   * @param listOfSquat a female lifters squat numbers over the past three weeks.
   * @param currentWeight a female lifters current weight.
   *
   * @return a female lifters ELO after considering their squat.
   */
  override fun addSquatFactors(currentELO: Int,
                               squatMax: Float,
                               listOfSquat: List<Float>,
                               currentWeight: Float): Int {
  
    var newELO = currentELO
    val threeWeekAverage = listOfSquat.sum() / listOfSquat.size
    val squatToBWRatio = squatMax / currentWeight
  
    newELO += when (squatToBWRatio) {
    
      in 0.0..0.45 -> {
        1 // beginner
      }
      in 0.45 .. 0.85 -> {
        2 // novice
      }
      in 0.85 .. 1.3 -> {
        3 // intermediate
      }
      in 1.3 .. 2.5 -> {
        4 // advanced
      }
      else -> {
        5 // elite
      }
    
    }
  
    return 0
    
  }
  
  /**
   * This method outlines how ELO is added taking into account the body weight
   * to deadlift ratio.
   *
   * @param currentELO the ELO before taking into account
   *                    the deadlift.
   * @param deadLiftMax a female lifters deadlift max for the week.
   *  @param listOfDeadlift a female lifters deadlift numbers over the past three weeks.
   * @param currentWeight a female lifters current weight.
   *
   * @return a male lifters ELO after considering their deadlift.
   */
  override fun addDeadLiftFactors(
    currentELO: Int,
    deadLiftMax: Float,
    listOfDeadlift: List<Float>,
    currentWeight: Float
  ): Int {
  
    val deadLiftToBWRatio = deadLiftMax / currentWeight
    val threeWeekAverage = listOfDeadlift.sum() / listOfDeadlift.size
    var newELO = currentELO
  
    newELO += when (deadLiftToBWRatio) {
    
      in 0.0 .. 0.6 -> {
        1 // beginner
      }
      in 0.6 .. 1.1 -> {
        2 // novice
      }
      in 1.1 .. 1.6 -> {
        3 // intermediate
      }
      in 1.6 .. 2.3 -> {
        4 // advanced
      }
      else -> {
        5 // elite
      }
    
    }
    
    return 0
  }
}