package com.uplift.backend.dao

import com.uplift.backend.dao.impl.FemaleRatioFactors
import com.uplift.backend.dao.impl.MaleRatioFactors
import com.uplift.backend.dto.Gender
import com.uplift.backend.dto.LiftData
import com.uplift.backend.dto.UpdateELO
import com.uplift.backend.utils.analyseLifts
import com.uplift.backend.utils.analyseSpecialtyLift

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
  
  /**
   * This function is purposed with determining the
   * updated ELO of existing lifters on the platform.
   *
   * @return the updated ELO of the existing lifter.
   */
  fun calculate(): Int {
    val list = listOf(this.addBenchMax(),
                      this.addSquatMax(),
                      this.addDeadLiftMax())
    
    return analyseLifts(updateELO.currentELO, list)
  }
  
  /**
   * This function is purposed with determining the
   * updated ELO of existing lifters on the platform.
   *
   * @return the updated ELO of the existing lifter.
   */
  fun calculateSquatSpecialty(): Int {
    val liftData = this.addSquatMax()
    return analyseSpecialtyLift(updateELO.currentELO, liftData)
  }
  
  /**
   * This function is purposed with determining the
   * updated ELO of existing lifters on the platform.
   *
   * @return the updated ELO of the existing lifter.
   */
  fun calculateBenchSpecialty(): Int {
    val liftData = this.addBenchMax()
    return analyseSpecialtyLift(updateELO.currentELO, liftData)
  }
  
  /**
   * This function is purposed with determining the
   * updated ELO of existing lifters on the platform.
   *
   * @return the updated ELO of the existing lifter.
   */
  fun calculateDeadliftSpecialty(): Int {
    val liftData = this.addDeadLiftMax()
    return analyseSpecialtyLift(updateELO.currentELO, liftData)
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
        updateELO.benchMax!!,
        updateELO.listOfBench!!,
        updateELO.weight)
    else
      femaleFactors.addBenchFactors(
      updateELO.benchMax!!,
      updateELO.listOfBench!!,
      updateELO.weight)
  }
  
  /**
   * This function takes into account a lifters
   * squat and creates a LiftData object accordingly.
   *
   * @return a LiftData object.
   */
  private fun addSquatMax(): LiftData {
    return if (updateELO.gender == Gender.MALE)
      maleFactors.addSquatFactors(
        updateELO.squatMax!!,
        updateELO.listOfSquat!!,
        updateELO.weight)
    else
      femaleFactors.addSquatFactors(
        updateELO.squatMax!!,
        updateELO.listOfSquat!!,
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
        updateELO.deadLiftMax!!,
        updateELO.listOfDeadlift!!,
        updateELO.weight)
    else
      femaleFactors.addDeadLiftFactors(
        updateELO.deadLiftMax!!,
        updateELO.listOfDeadlift!!,
        updateELO.weight)
  }
}