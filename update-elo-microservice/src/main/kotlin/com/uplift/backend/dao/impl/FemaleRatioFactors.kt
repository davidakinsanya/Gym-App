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
    TODO("Not yet implemented")
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
    TODO("Not yet implemented")
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
    TODO("Not yet implemented")
  }
  
  
}