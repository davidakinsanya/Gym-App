package com.uplift.backend.dao

import com.uplift.backend.dao.impl.FemaleRatioFactors
import com.uplift.backend.dao.impl.MaleRatioFactors
import com.uplift.backend.dto.Gender
import com.uplift.backend.dto.LiftData
import com.uplift.backend.dto.UpdateELO

/**
 * This class accepts information from existing lifters to determine
 * the lifters ELO increments on the platform.
 *
 * @param updateELO an updateELO object.
 *
 * @author David
 */
class CalculateUpdateELO(private val updateELO: UpdateELO) {
  
  private val maleFactors = MaleRatioFactors()
  private val femaleFactors = FemaleRatioFactors()
  
  fun calculate(): Int {
    var list = listOf(this.addBenchMax(),
                      this.addSquatMax(),
                      this.addDeadLiftMax())
    
    return 0
  }
  
  /**
   * This function takes into account a lifters
   * bench press and creates a LiftData object accordingly.
   *
   * @return a LiftData object.
   */
  private fun addBenchMax(): LiftData {
    return if (updateELO.gender == Gender.MALE)
      maleFactors.addBenchFactors(
        updateELO.benchMax,
        updateELO.listOfBench,
        updateELO.weight)
    else
      femaleFactors.addBenchFactors(
      updateELO.benchMax,
      updateELO.listOfBench,
      updateELO.weight)
  }
  
  /**
   * This function takes into account a lifters
   * squats and creates a LiftData object accordingly.
   *
   * @return a LiftData object.
   */
  private fun addSquatMax(): LiftData {
    return if (updateELO.gender == Gender.MALE)
      maleFactors.addSquatFactors(
        updateELO.squatMax,
        updateELO.listOfSquat,
        updateELO.weight)
    else
      femaleFactors.addSquatFactors(
        updateELO.squatMax,
        updateELO.listOfSquat,
        updateELO.weight)
  }
  
  /**
   * This function takes into account a lifters
   * deadlift and creates a LiftData object accordingly.
   *
   * @return a LiftData object.
   */
  private fun addDeadLiftMax(): LiftData {
    return if (updateELO.gender == Gender.MALE)
      maleFactors.addDeadLiftFactors(
        updateELO.deadLiftMax,
        updateELO.listOfDeadlift,
        updateELO.weight)
    else
      femaleFactors.addDeadLiftFactors(
        updateELO.deadLiftMax,
        updateELO.listOfDeadlift,
        updateELO.weight)
  }
}