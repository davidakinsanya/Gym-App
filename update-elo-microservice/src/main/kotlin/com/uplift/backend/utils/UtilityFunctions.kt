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
  val standardListNumbers = mutableListOf<Int>()
  val listCheckNum = mutableListOf<Int>()
  
  for (lift in liftData) {
    standardList += lift.standard
    listCheckNum += liftCheck(lift)
  }
  
  for (standard in standardList) standardListNumbers += standardCheck(standard, standardList)
  
  return currentELO
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
 * @param standard a Standard enum.
 * @param standardList a list of the lifter's performance across
 *                     the big three compound lifts.
 *
 * @return an integer representing how many times
 *         a lifter produced a lift of a specific standard across the big three
 *         compound lifts.
 *
 */
fun standardCheck(standard: Standard, standardList: List<Standard>): Int {
  when (standard) {
    Standard.BEGINNER -> {
      if (standardList.count(generatePredicate(standard)) >= 2) return 1
      if (standardList.count(generatePredicate(standard)) == 1) return 2
    }
    
    Standard.NOVICE -> {
      if (standardList.count(generatePredicate(standard)) >= 2) return 3
      if (standardList.count(generatePredicate(standard)) == 1) return 4
    }
    
    Standard.INTERMEDIATE -> {
      if (standardList.count(generatePredicate(standard)) >= 2) return 5
      if (standardList.count(generatePredicate(standard)) == 1) return 6
    }
    
    Standard.ADVANCED -> {
      if (standardList.count(generatePredicate(standard)) >= 2) return 7
      if (standardList.count(generatePredicate(standard)) == 1) return 8
    }
    
    Standard.ELITE -> {
      if (standardList.count(generatePredicate(standard)) >= 2) return 9
      if (standardList.count(generatePredicate(standard)) == 1) return 10
    }
  }
  return -1
}

/**
 * This method compares the lifters most recent lift of a specific
 * compound lift against the lifters last three lifts.
 *
 * @param liftData a LiftData object.
 * @return an integer representing the proximity between the
 *         lifters most current lift and the last three recorded lifts.
 */
fun liftCheck(liftData: LiftData): Int {
  val avgLifts = liftData.listOfLifts.sum() / liftData.listOfLifts.size
  
  return 0
}