package com.uplift.backend.dao.impl

import com.uplift.backend.dao.intrface.Factors
import com.uplift.backend.dto.Gender
import com.uplift.backend.dto.Lift
import com.uplift.backend.dto.LiftData
import com.uplift.backend.dto.Standard

// https://strengthlevel.com/strength-standards/male/kg

/**
 * This class is purposed with defining the logic of the functions which
 * analyses the body weight to lift ratios of male lifters and adds ELO
 * accordingly.
 *
 * @author David
 */

class MaleRatioFactors: Factors {
  
  /**
   * This method outlines how ELO is added taking into account the body weight
   * to bench ratio.
   *
   * @param benchMax a male lifters bench max for the week.
   * @param listOfBench a male lifters bench press numbers over the past three weeks.
   * @param currentWeight a male lifters current weight.
   *
   * @return a LiftData object.
   */
  override fun addBenchFactors(benchMax: Float,
                               listOfBench: List<Float>,
                               currentWeight: Float): LiftData {
    
    return when (benchMax / currentWeight) {
      
      in 0.0 .. 0.5 -> {
        LiftData(gender = Gender.MALE, lift = Lift.BENCH, standard = Standard.BEGINNER, listOfLifts = listOfBench)
      }
      in 0.5 .. 1.0 -> {
        LiftData(gender = Gender.MALE, lift = Lift.BENCH, standard = Standard.NOVICE, listOfLifts = listOfBench)
      }
      in 1.1 .. 1.5 -> {
        LiftData(gender = Gender.MALE, lift = Lift.BENCH, standard = Standard.INTERMEDIATE, listOfLifts = listOfBench)
      }
      in 1.5 .. 2.0 -> {
        LiftData(gender = Gender.MALE, lift = Lift.BENCH, standard = Standard.ADVANCED, listOfLifts = listOfBench)
      } else -> {
        LiftData(gender = Gender.MALE, lift = Lift.BENCH, standard = Standard.ELITE, listOfLifts = listOfBench)
      }
    }
  }
  
  /**
   * This method outlines how ELO is added taking into account the body weight
   * to squat ratio.
   *
   * @param squatMax a male lifters squat max for the week.
   * @param listOfSquat a male lifters squat numbers over the past three weeks.
   * @param currentWeight a male lifters current weight.
   *
   * @return a LiftData object.
   */
  override fun addSquatFactors(squatMax: Float,
                               listOfSquat: List<Float>,
                               currentWeight: Float): LiftData {
  
    return when (squatMax / currentWeight) {
      
      in 0.0 .. 0.8 -> {
       LiftData(gender = Gender.MALE, lift = Lift.SQUAT, standard = Standard.BEGINNER, listOfLifts = listOfSquat)
      }
      in 0.9 .. 1.2 -> {
        LiftData(gender = Gender.MALE, lift = Lift.SQUAT, standard = Standard.NOVICE, listOfLifts = listOfSquat)
      }
      in 1.2 .. 1.6 -> {
        LiftData(gender = Gender.MALE, lift = Lift.SQUAT, standard = Standard.INTERMEDIATE, listOfLifts = listOfSquat)
      }
      in 1.6 .. 2.3 -> {
        LiftData(gender = Gender.MALE, lift = Lift.SQUAT, standard = Standard.ADVANCED, listOfLifts = listOfSquat)
      }
      else -> {
        LiftData(gender = Gender.MALE, lift = Lift.SQUAT, standard = Standard.ELITE, listOfLifts = listOfSquat)
      }
    }
  }
  
  /**
   * This method outlines how ELO is added taking into account the body weight
   * to deadlift ratio.
   *
   * @param deadLiftMax a male lifters deadlift max for the week.
   *  @param listOfDeadlift a male lifters deadlift numbers over the past three weeks.
   * @param currentWeight a male lifters current weight.
   *
   * @return a LiftData object..
   */
  override fun addDeadLiftFactors(deadLiftMax: Float,
                                  listOfDeadlift: List<Float>,
                                  currentWeight: Float): LiftData {
  
    return when (deadLiftMax / currentWeight) {
  
      in 0.0 .. 0.9 -> {
        LiftData(gender = Gender.MALE, lift = Lift.DEADLIFT, standard = Standard.BEGINNER, listOfLifts = listOfDeadlift)
      }
      in 0.9 .. 1.4 -> {
        LiftData(gender = Gender.MALE, lift = Lift.DEADLIFT, standard = Standard.NOVICE, listOfLifts = listOfDeadlift)
      }
      in 1.4 .. 1.9 -> {
        LiftData(gender = Gender.MALE, lift = Lift.DEADLIFT, standard = Standard.INTERMEDIATE, listOfLifts = listOfDeadlift)
      }
      in 1.9 .. 2.7 -> {
        LiftData(gender = Gender.MALE, lift = Lift.DEADLIFT, standard = Standard.ADVANCED, listOfLifts = listOfDeadlift)
      }
      else -> {
        LiftData(gender = Gender.MALE, lift = Lift.DEADLIFT, standard = Standard.ELITE, listOfLifts = listOfDeadlift)
      }
    }
  }
}