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
    var list = listOf<LiftData>()
    if (updateELO.gender == Gender.MALE) {
      list = listOf(
        maleFactors.addBenchFactors(
        updateELO.benchMax,
        updateELO.listOfBench,
        updateELO.weight),
        
        maleFactors.addSquatFactors(
          updateELO.squatMax,
          updateELO.listOfSquat,
          updateELO.weight),
  
        maleFactors.addDeadLiftFactors(
          updateELO.deadLiftMax,
          updateELO.listOfDeadlift,
          updateELO.weight),
      )
    } else {
      list = listOf(
        femaleFactors.addBenchFactors(
          updateELO.benchMax,
          updateELO.listOfBench,
          updateELO.weight),
    
        femaleFactors.addSquatFactors(
          updateELO.squatMax,
          updateELO.listOfSquat,
          updateELO.weight),
    
        femaleFactors.addDeadLiftFactors(
          updateELO.deadLiftMax,
          updateELO.listOfDeadlift,
          updateELO.weight),
      )
    }
    return 0
  }
  
}