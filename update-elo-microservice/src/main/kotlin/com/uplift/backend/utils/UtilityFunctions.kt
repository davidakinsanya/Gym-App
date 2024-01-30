package com.uplift.backend.utils

import com.uplift.backend.dto.LiftData
import com.uplift.backend.dto.Standard

/**
 * This method analyses the lift data and updates the lifters ELO accordingly.
 *
 * @param currentELO the lifters current ELO rating.
 * @param liftData a LiftData object.
 *
 * @return the lifters updated ELO.
 */
fun analyseLifts(currentELO: Int, liftData: List<LiftData>): Int {
  
  val standardList = mutableListOf<Standard>()
  val checkLiftPercentages = mutableListOf<Float>()
  
  for (lift in liftData) {
    standardList += lift.standard
    checkLiftPercentages += liftCheck(lift)
  }
  var majorityStandard: Standard = Standard.BEGINNER
  
  if(!uniqueStandards(standardList))
   majorityStandard = standardCheck(standardList)
  
  return calculateFinalELO(checkLiftPercentages.sum(), majorityStandard, currentELO)
}

/**
 * This method produces a predicate statement representing how many times
 * a lifter produced a lift of a specific standard across the big three
 * compound lifts.
 *
 * @param standard a Standard enum.
 *
 * @return a predicate statement used for the count() method.
 */
fun generatePredicate(standard: Standard): (Standard) -> Boolean = {it == standard}

/**
 * * This method assesses how many times
 * a lifter produced a lift of a specific standard across the big three
 * compound lifts.
 *
 * @param standardList a list of the lifter's performance across
 *                     the big three compound lifts.
 *
 * @return an integer representing how many times
 *         a lifter produced a lift of a specific standard across the big three
 *         compound lifts.
 *
 */
fun standardCheck(standardList: List<Standard>): Standard {
  for (standard in Standard.values())
    when (standard) {
      Standard.BEGINNER -> {
        if (standardList.count(generatePredicate(standard)) >= 2) return Standard.BEGINNER
      }
      
      Standard.NOVICE -> {
        if (standardList.count(generatePredicate(standard)) >= 2) return Standard.NOVICE
      }
      
      Standard.INTERMEDIATE -> {
        if (standardList.count(generatePredicate(standard)) >= 2) return Standard.INTERMEDIATE
      }
      
      Standard.ADVANCED -> {
        if (standardList.count(generatePredicate(standard)) >= 2) return Standard.ADVANCED
      }
      
      Standard.ELITE -> {
        if (standardList.count(generatePredicate(standard)) >= 2) return Standard.ELITE
      }
    }
  return Standard.BEGINNER
}

/**
 * This function checks if all lifts are performed at
 * different levels of strength.
 *
 * @param standardList a list of the lifter's performance across
 *                     the big three compound lifts.
 *
 * @return a boolean which checks if all lifts are performed
 *         at different levels of strength.
 */
fun uniqueStandards(standardList: List<Standard>): Boolean {
  return standardList.size > standardList.toSet().size
}

/**
 * This method compares the lifters most recent lift of a specific
 * compound lift against the lifters last three lifts.
 *
 * @param liftData a LiftData object.
 *
 * @return a percentage increase or decrease comparing current maxes
 *        to average performance over time.
 */
fun liftCheck(liftData: LiftData): Float {
  val avgLifts = liftData.listOfLifts.sum() / liftData.listOfLifts.size
  
  return if (liftData.currentMax >= avgLifts)
          (1 + (liftData.currentMax - avgLifts)/avgLifts * 100)
  
  else  (1 + (avgLifts - liftData.currentMax)/liftData.currentMax * 100)
}


fun calculateFinalELO(avg: Float, standard: Standard, currentELO: Int): Int {
  var newELO = currentELO
  when (standard) {
    Standard.BEGINNER -> {
      newELO += 5
    }
    Standard.NOVICE -> {
      newELO += 4
    }
    Standard.INTERMEDIATE -> {
      newELO += 3
    }
    Standard.ADVANCED -> {
      newELO += 2
    }
    Standard.ELITE -> {
      newELO += 1
    }
  }
  return (newELO + avg).toInt()
}