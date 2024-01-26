package com.uplift.backend.dao.impl

import com.uplift.backend.dao.intrface.Factors

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
   * This method outlines how ELO is added taking into account the body weight
   * to bench ratio.
   *
   * @param currentELO the ELO before taking into account the bench press.
   * @param benchMax a male lifters bench max for the week.
   * @param listOfBench a male lifters bench press numbers over the past three weeks.
   * @param currentWeight a male lifters current weight.
   *
   * @return a male lifters ELO after considering their bench.
   */
  override fun addBenchFactors(currentELO: Int,
                               benchMax: Float,
                               listOfBench: List<Float>,
                               currentWeight: Float): Int {
  
    var newELO = currentELO
    val threeWeekAverage = listOfBench.sum() / listOfBench.size
    val benchToBWRatio = benchMax / currentWeight
  
    newELO += when (benchToBWRatio) {
      
      in 0.0 .. 1.6 -> {
        1  // beginner
      }
      in 1.6 .. 1.7 -> {
        2  // intermediate
      }
      in 1.7 .. 2.0 -> {
        3  // advanced
      } else -> {
       5   // elite
      }
      
    }
    
    return 0
  }
  
  /**
   * This method outlines how ELO is added taking into account the body weight
   * to squat ratio.
   *
   * @param currentELO the ELO before taking into account the squat.
   * @param squatMax a male lifters squat max for the week.
   * @param listOfSquat a male lifters squat numbers over the past three weeks.
   * @param currentWeight a male lifters current weight.
   *
   * @return a male lifters ELO after considering their squat.
   */
  override fun addSquatFactors(currentELO: Int,
                               squatMax: Float,
                               listOfSquat: List<Float>,
                               currentWeight: Float): Int {
    var newELO = currentELO
    val threeWeekAverage = listOfSquat.sum() / listOfSquat.size
    val squatToBWRatio = squatMax / currentWeight
    
    newELO += when (squatToBWRatio) {
      
      in 0.0 .. 0.8 -> {
        1 // beginner
      }
      in 0.9 .. 1.2 -> {
        2 // novice
      }
      in 1.2 .. 1.6 -> {
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
  
  /**
   * This method outlines how ELO is added taking into account the body weight
   * to deadlift ratio.
   *
   * @param currentELO the ELO before taking into account
   *                    the deadlift.
   * @param deadLiftMax a male lifters deadlift max for the week.
   *  @param listOfDeadlift a male lifters deadlift numbers over the past three weeks.
   * @param currentWeight a male lifters current weight.
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
  
      in 0.0 .. 0.9 -> {
        1 // beginner
      }
      in 0.9 .. 1.4 -> {
        2 // novice
      }
      in 1.4 .. 1.9 -> {
        3 // intermediate
      }
      in 1.9 .. 2.7 -> {
        4 // advanced
      }
      else -> {
        5 // elite
      }
      
    }
    
    return 0
  }
}