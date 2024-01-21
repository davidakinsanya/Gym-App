package com.uplift.backend.dao.intrface

import com.uplift.backend.dto.StartingELO

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
   * @param startingELO the StartingELO object representing
   *                    a new lifters basic information.
   * @param currentWeight a new lifters current weight.
   */
  fun addBenchFactors(currentELO: Int,
                      startingELO: StartingELO,
                      currentWeight: Float): Int
  
  /**
   * This method outlines how ELO is added taking into account the body weight
   * to squat ratio.
   *
   * @param currentELO the ELO before taking into account the squat.
   * @param startingELO the StartingELO object representing
   *                    a new lifters basic information.
   * @param currentWeight a new lifters current weight.
   */
  fun addSquatFactors(currentELO: Int,
                      startingELO: StartingELO,
                      currentWeight: Float): Int
  
  
  /**
   * This method outlines how ELO is added taking into account the body weight
   * to deadlift ratio.
   *
   * @param currentELO the ELO before taking into account
   *                    the deadlift.
   * @param startingELO the StartingELO object representing
   *                    a new lifters basic information.
   * @param currentWeight a new lifters current weight.
   */
  fun addDeadLiftFactors(currentELO: Int,
                         startingELO: StartingELO,
                         currentWeight: Float): Int
  
}