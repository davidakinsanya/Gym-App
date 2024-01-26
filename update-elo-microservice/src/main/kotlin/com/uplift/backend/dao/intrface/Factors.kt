package com.uplift.backend.dao.intrface

/**
 * This interface is purposed with outlining the functions which analyses
 * the body weight to lift ratios of male and women lifters.
 *
 * @author David
 */
interface Factors {
  
  /**
   * This method outlines how ELO is added taking into account the body weight
   * to bench ratio.
   *
   * @param currentELO the ELO before taking into account the bench press.
   * @param benchMax the lifters bench max for the week.
   * @param listOfBench the lifters bench press numbers over the past three weeks.
   * @param currentWeight a new lifters current weight.
   *
   * @return the lifters ELO after considering their bench.
   */
  fun addBenchFactors(currentELO: Int,
                      benchMax: Float,
                      listOfBench: List<Float>,
                      currentWeight: Float): Int
  
  /**
   * This method outlines how ELO is added taking into account the body weight
   * to squat ratio.
   *
   * @param currentELO the ELO before taking into account the squat.
   * @param squatMax the lifters squat max for the week.
   * @param listOfSquat the lifters squat numbers over the past three weeks.
   * @param currentWeight a new lifters current weight.
   *
   * @return the lifters ELO after considering their squat.
   */
  fun addSquatFactors(currentELO: Int,
                      squatMax: Float,
                      listOfSquat: List<Float>,
                      currentWeight: Float): Int
  
  
  /**
   * This method outlines how ELO is added taking into account the body weight
   * to deadlift ratio.
   *
   * @param currentELO the ELO before taking into account
   *                    the deadlift.
   * @param deadLiftMax the lifters deadlift max for the week.
   *  @param listOfDeadlift the lifters deadlift numbers over the past three weeks.
   * @param currentWeight a new lifters current weight.
   *
   * @return the lifters ELO after considering their deadlift.
   */
  fun addDeadLiftFactors(currentELO: Int,
                         deadLiftMax: Float,
                         listOfDeadlift: List<Float>,
                         currentWeight: Float): Int
  
}