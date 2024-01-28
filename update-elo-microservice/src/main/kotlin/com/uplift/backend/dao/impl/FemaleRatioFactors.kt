package com.uplift.backend.dao.impl

import com.uplift.backend.dao.intrface.Factors
import com.uplift.backend.dto.Gender
import com.uplift.backend.dto.Lift
import com.uplift.backend.dto.LiftData
import com.uplift.backend.dto.Standard

// https://strengthlevel.com/strength-standards/female/kg

/**
 * This class is purposed with defining the logic of the functions which
 * analyses the body weight to lift ratios of female lifters and adds ELO
 * accordingly.
 *
 * @author David
 */
class FemaleRatioFactors: Factors {
  
  /**
   * This method outlines how ELO is added taking into account the body weight
   * to bench ratio.
   *
   * @param benchMax a female lifters bench max for the week.
   * @param listOfBench a female lifters bench press numbers over the past three weeks.
   * @param currentWeight a female lifters current weight.
   *
   * @return a LiftData object.
   */
  override fun addBenchFactors(benchMax: Float,
                               listOfBench: List<Float>,
                               currentWeight: Float): LiftData {
  
    return when (benchMax / currentWeight) {
    
      in 0.0 .. 0.2 -> {
        LiftData(gender = Gender.FEMALE, lift = Lift.BENCH, standard = Standard.BEGINNER, currentMax = benchMax, listOfLifts = listOfBench)
      }
      in 0.2 .. 0.6 -> {
        LiftData(gender = Gender.FEMALE, lift = Lift.BENCH, standard = Standard.NOVICE, currentMax = benchMax, listOfLifts = listOfBench)
      }
      in 0.6 .. 0.9 -> {
        LiftData(gender = Gender.FEMALE, lift = Lift.BENCH, standard = Standard.INTERMEDIATE, currentMax = benchMax, listOfLifts = listOfBench)
      }
      in 0.9 .. 1.3 -> {
        LiftData(gender = Gender.FEMALE, lift = Lift.BENCH, standard = Standard.ADVANCED, currentMax = benchMax, listOfLifts = listOfBench)
      } else -> {
        LiftData(gender = Gender.FEMALE, lift = Lift.BENCH, standard = Standard.ELITE, currentMax = benchMax, listOfLifts = listOfBench)
      }
    }
  }
  
  /**
   * This method outlines how ELO is added taking into account the body weight
   * to squat ratio.
   *
   * @param squatMax a female lifters squat max for the week.
   * @param listOfSquat a female lifters squat numbers over the past three weeks.
   * @param currentWeight a female lifters current weight.
   *
   * @return a LiftData object.
   */
  override fun addSquatFactors(squatMax: Float,
                               listOfSquat: List<Float>,
                               currentWeight: Float): LiftData {
  
    return when (squatMax / currentWeight) {
    
      in 0.0..0.45 -> {
        LiftData(gender = Gender.FEMALE, lift = Lift.SQUAT, standard = Standard.BEGINNER, currentMax = squatMax, listOfLifts = listOfSquat)
      }
      in 0.45 .. 0.85 -> {
        LiftData(gender = Gender.FEMALE, lift = Lift.SQUAT, standard = Standard.NOVICE, currentMax = squatMax, listOfLifts = listOfSquat)
      }
      in 0.85 .. 1.3 -> {
        LiftData(gender = Gender.FEMALE, lift = Lift.SQUAT, standard = Standard.INTERMEDIATE, currentMax = squatMax, listOfLifts = listOfSquat)
      }
      in 1.3 .. 2.5 -> {
        LiftData(gender = Gender.FEMALE, lift = Lift.SQUAT, standard = Standard.ADVANCED, currentMax = squatMax, listOfLifts = listOfSquat)
      }
      else -> {
        LiftData(gender = Gender.FEMALE, lift = Lift.SQUAT, standard = Standard.ELITE, currentMax = squatMax, listOfLifts = listOfSquat)
      }
    }
  }
  
  /**
   * This method outlines how ELO is added taking into account the body weight
   * to deadlift ratio.
   *
   * @param deadLiftMax a female lifters deadlift max for the week.
   *  @param listOfDeadlift a female lifters deadlift numbers over the past three weeks.
   * @param currentWeight a female lifters current weight.
   *
   * @return a LiftData object.
   */
  override fun addDeadLiftFactors(deadLiftMax: Float,
                                  listOfDeadlift: List<Float>,
                                  currentWeight: Float): LiftData {
  
    return when (deadLiftMax / currentWeight) {
    
      in 0.0 .. 0.6 -> {
        LiftData(gender = Gender.FEMALE, lift = Lift.DEADLIFT, standard = Standard.BEGINNER, currentMax = deadLiftMax, listOfLifts = listOfDeadlift)
      }
      in 0.6 .. 1.1 -> {
        LiftData(gender = Gender.FEMALE, lift = Lift.DEADLIFT, standard = Standard.NOVICE, currentMax = deadLiftMax, listOfLifts = listOfDeadlift)
      }
      in 1.1 .. 1.6 -> {
        LiftData(gender = Gender.FEMALE, lift = Lift.DEADLIFT, standard = Standard.INTERMEDIATE, currentMax = deadLiftMax, listOfLifts = listOfDeadlift)
      }
      in 1.6 .. 2.3 -> {
        LiftData(gender = Gender.FEMALE, lift = Lift.DEADLIFT, standard = Standard.ADVANCED, currentMax = deadLiftMax, listOfLifts = listOfDeadlift)
      }
      else -> {
        LiftData(gender = Gender.FEMALE, lift = Lift.DEADLIFT, standard = Standard.ELITE, currentMax = deadLiftMax, listOfLifts = listOfDeadlift)
      }
    }
  }
}