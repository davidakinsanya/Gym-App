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
  
  return calculateFinalELO(avg = checkLiftPercentages.sum(), standard = uniqueStandards(standardList), currentELO = currentELO)
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
 * @return the average or most consistent standard out of the
 *         three standards of the separate lifts.
 */
fun uniqueStandards(standardList: List<Standard>): Standard {
  return if (standardList.size <= standardList.toSet().size) standardCheck(standardList)
  else {
    val ordinalList = mutableListOf<Int>()
    for (standard in standardList)
      ordinalList += standard.ordinal
    ordinalList.sort()
    Standard.values()[ordinalList[1]]
  }
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
          (liftData.currentMax - avgLifts)/avgLifts
  
  else  (avgLifts - liftData.currentMax)/liftData.currentMax
}

/**
 * This method calculates the final ELO increment.
 *
 * @param avg an average percentage increase or decrease
 *            across the big three lifts.
 *
 * @param standard the majority standard across the big three lifts.
 * @param currentELO the lifters current ELO.
 *
 * @return the new ELO rating.
 */
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
  
  when (avg) {
    in 0.0..0.05 -> {
      newELO += 1
    }
  
    in 0.05..0.1 -> {
      newELO += 2
    }
  
    in 0.0..0.05 -> {
      newELO += 3
    }
  
    in 0.05..0.1 -> {
      newELO += 4
    }
    in 0.1..0.15 -> {
      newELO += 5
    }
  
    in 0.15..0.2 -> {
      newELO += 6
    }
  
    in 0.2..0.25 -> {
      newELO += 8
    }
  
    in 0.25..1.0 -> {
      newELO += 10
    }
  }
  return newELO
}