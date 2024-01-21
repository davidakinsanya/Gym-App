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
    
    if (startingELO.benchMax <= 60) {
      STARTING_ELO += 25
    }
    
    else if (startingELO.benchMax > 60 && startingELO.benchMax <= 80) {
      STARTING_ELO += 50
    }

    else if (startingELO.benchMax > 80 && startingELO.benchMax <= 100) {
      STARTING_ELO += 100
    }

    else if (startingELO.benchMax > 100 && startingELO.benchMax <= 120) {
      STARTING_ELO += 125
    }
  
    if (startingELO.benchMax <= 120) {
      STARTING_ELO += 150
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
    
    if (startingELO.squatMax <= 60) {
      STARTING_ELO += 25
    }
    
    else if (startingELO.squatMax > 60 && startingELO.squatMax <= 80) {
      STARTING_ELO += 50
    }
    
    
    else if (startingELO.squatMax > 80 && startingELO.squatMax <= 100) {
      STARTING_ELO += 100
    }
    
    else if (startingELO.squatMax > 100 && startingELO.squatMax <= 120) {
      STARTING_ELO += 125
    }
    
    if (startingELO.squatMax <= 120) {
      STARTING_ELO += 150
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
    
    if (startingELO.deadLiftMax <= 60) {
      STARTING_ELO += 25
    }
    else if (startingELO.deadLiftMax > 60 && startingELO.deadLiftMax <= 80) {
      STARTING_ELO += 50
    }
    
    else if (startingELO.deadLiftMax > 80 && startingELO.deadLiftMax <= 100) {
      STARTING_ELO += 100
    }
    
    else if (startingELO.deadLiftMax > 100 && startingELO.deadLiftMax <= 120) {
      STARTING_ELO += 125
    }
    
    if (startingELO.deadLiftMax <= 120) {
      STARTING_ELO += 150
    }
  
    if (startingELO.gender.gender == "M")
      return maleFactors.addDeadLiftFactors(STARTING_ELO, startingELO, startingELO.weight)
  
    return femaleFactors.addDeadLiftFactors(STARTING_ELO, startingELO, startingELO.weight)
  }
}