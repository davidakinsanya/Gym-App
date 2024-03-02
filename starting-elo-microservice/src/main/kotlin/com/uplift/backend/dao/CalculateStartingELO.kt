package com.uplift.backend.dao


import com.uplift.backend.dao.impl.FemaleRatioFactors
import com.uplift.backend.dao.impl.MaleRatioFactors
import com.uplift.backend.dto.StartingELO

/**
 * This class accepts information from new lifters to determine
 * the lifters starting ELO on the platform.
 *
 * @param startingELO the StartingELO object representing
 *                    a new lifters basic information.
 *
 * @author David
 */
class CalculateStartingELO(private val startingELO: StartingELO) {
  
  private var STARTING_ELO = 1000
  
  private val maleFactors = MaleRatioFactors()
  private val femaleFactors = FemaleRatioFactors()
  
  /**
   * This function is purposed with determining the
   * starting ELO of new lifters on the platform.
   *
   * @return the starting ELO of the new lifter.
   */
  fun calculate(): Int {
    this.addGender()
    this.addBenchMax()
    this.addSquatMax()
    
    return this.addDeadLiftMax()
  }
  
  /**
   * This function is purposed with determining a
   * specialty ELO of new premium lifters on the platform.
   *
   * @return the specialty ELO of the new lifter.
   */
  fun calculateBenchSpecialty(): Int {
    this.addGender()
    return this.addBenchMax()
  }
  
  /**
   * This function is purposed with determining a
   * specialty ELO of new premium lifters on the platform.
   *
   * @return the specialty ELO of the new lifter.
   */
  fun calculateSquatSpecialty(): Int {
    this.addGender()
    return this.addSquatMax()
  }
  
  /**
   * This function is purposed with determining a
   * specialty ELO of new premium lifters on the platform.
   *
   * @return the specialty ELO of the new lifter.
   */
  fun calculateDeadliftSpecialty(): Int {
    this.addGender()
    return this.addDeadLiftMax()
  }
  
  /**
   * This function takes into account a lifters
   * gender and adds to the ELO accordingly.
   *
   * @return the ELO after gender is taken into account.
   */
  private fun addGender(): Int {
    if (startingELO.gender.gender == "M")
      STARTING_ELO += 25
    
    return STARTING_ELO
  }
  
  /**
   * This function takes into account a lifters
   * bench press and adds to the ELO accordingly.
   *
   * @return the ELO after the bench press
   *         is taken into account.
   */
  private fun addBenchMax(): Int {
    
    STARTING_ELO += when (startingELO.benchMax!!) {
      in 0.0 .. 60.0 -> {
        25
      }
      in 60.0 .. 80.0 -> {
        50
      }
      in 80.0 .. 100.0 -> {
        100
      }
      in 100.0 .. 120.0 -> {
        125
      }
      else -> {
        150
      }
    }
    
    if (startingELO.gender.gender == "M")
      return maleFactors.addBenchFactors(STARTING_ELO, startingELO, startingELO.weight)
    
    return femaleFactors.addBenchFactors(STARTING_ELO, startingELO, startingELO.weight)
  }
  
  /**
   * This function takes into account a lifters
   * squat and adds to the ELO accordingly.
   *
   * @return the ELO after the squat
   *         is taken into account.
   */
  private fun addSquatMax(): Int {
    
    STARTING_ELO += when (startingELO.squatMax!!) {
      in 0.0 .. 60.0 -> {
        25
      }
      in 60.0 .. 80.0 -> {
        50
      }
      in 80.0 .. 100.0 -> {
        100
      }
      in 100.0 .. 120.0 -> {
        125
      }
      else -> {
        150
      }
    }
    
    if (startingELO.gender.gender == "M")
      return maleFactors.addSquatFactors(STARTING_ELO, startingELO, startingELO.weight)
    
    return femaleFactors.addSquatFactors(STARTING_ELO, startingELO, startingELO.weight)
  }
  
  /**
   * This function takes into account a lifters
   * deadlift and adds to the ELO accordingly.
   *
   * @return the ELO after the deadlift
   *         is taken into account.
   */
  private fun addDeadLiftMax(): Int {
    
    STARTING_ELO += when (startingELO.deadLiftMax!!) {
      in 0.0 .. 60.0 -> {
        25
      }
      in 60.0 .. 80.0 -> {
        50
      }
      in 80.0 .. 100.0 -> {
        100
      }
      in 100.0 .. 120.0 -> {
        125
      }
      else -> {
        150
      }
    }
    
    if (startingELO.gender.gender == "M")
      return maleFactors.addDeadLiftFactors(STARTING_ELO, startingELO, startingELO.weight)
    
    return femaleFactors.addDeadLiftFactors(STARTING_ELO, startingELO, startingELO.weight)
  }
}