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
    TODO("Not yet implemented")
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
    TODO("Not yet implemented")
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
    TODO("Not yet implemented")
  }
}