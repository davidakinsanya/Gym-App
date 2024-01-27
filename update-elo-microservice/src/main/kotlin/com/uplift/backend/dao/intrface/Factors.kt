package com.uplift.backend.dao.intrface

import com.uplift.backend.dto.LiftData

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
   * @param benchMax the lifters bench max for the week.
   * @param listOfBench the lifters bench press numbers over the past three weeks.
   * @param currentWeight a new lifters current weight.
   *
   * @return a LiftData object.
   */
  fun addBenchFactors(benchMax: Float,
                      listOfBench: List<Float>,
                      currentWeight: Float): LiftData
  
  /**
   * This method outlines how ELO is added taking into account the body weight
   * to squat ratio.
   *
   * @param squatMax the lifters squat max for the week.
   * @param listOfSquat the lifters squat numbers over the past three weeks.
   * @param currentWeight a new lifters current weight.
   *
   * @return a LiftData object.
   */
  fun addSquatFactors(squatMax: Float,
                      listOfSquat: List<Float>,
                      currentWeight: Float): LiftData
  
  
  /**
   * This method outlines how ELO is added taking into account the body weight
   * to deadlift ratio.
   *
   * @param deadLiftMax the lifters deadlift max for the week.
   *  @param listOfDeadlift the lifters deadlift numbers over the past three weeks.
   * @param currentWeight a new lifters current weight.
   *
   * @return a LiftData object.
   */
  fun addDeadLiftFactors(deadLiftMax: Float,
                         listOfDeadlift: List<Float>,
                         currentWeight: Float): LiftData
  
}