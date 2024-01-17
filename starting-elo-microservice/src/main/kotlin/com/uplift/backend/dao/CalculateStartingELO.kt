package dao

import com.uplift.backend.dao.impl.FemaleRatioFactors
import com.uplift.backend.dao.impl.MaleRatioFactors
import dto.StartingELO

class CalculateStartingELO(private val startingELO: StartingELO) {
  
  private var STARTING_ELO = 1000
  
  private val maleFactors = MaleRatioFactors()
  private val femaleFactors = FemaleRatioFactors()
  
  fun calculate(): Int {
    this.addGender()
    this.addBenchMax()
    this.addSquatMax()
    this.addDeadLiftMax()
    
    return STARTING_ELO
  }
  
  private fun addGender(): Int {
    if (startingELO.gender.gender == "M")
      STARTING_ELO += 25
    
    return STARTING_ELO
  }
  
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