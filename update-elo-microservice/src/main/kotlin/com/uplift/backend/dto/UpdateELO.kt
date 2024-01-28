package com.uplift.backend.dto

/**
 * This data class defines the information we take from existing lifters
 * to determine the users ELO increment.
 *
 * @param gender an enum object representing a new lifters gender.
 * @param age an integer representing a users current age.
 * @param weight a float representing a new lifters current weight.
 * @param squatMax a float representing a new lifters max squat.
 * @param benchMax a float representing a new lifters max bench press.
 * @param deadLiftMax a float representing a new lifters max deadlift.
 * @param listOfBench the lifters bench press numbers over the past three weeks.
 * @param listOfSquat a male lifters squat numbers over the past three weeks.
 * @param listOfDeadlift a male lifters deadlift numbers over the past three weeks.
 *
 * @author David
 */
data class UpdateELO(val gender: Gender,
                     val weight: Float,
                     val age: Int,
                     val benchMax: Float,
                     val squatMax: Float,
                     val deadLiftMax: Float,
                     val listOfBench: List<Float>,
                     val listOfSquat: List<Float>,
                     val listOfDeadlift: List<Float>)
