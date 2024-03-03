package com.uplift.backend.dto

/**
 * This data class defines the information we take from existing lifters
 * to determine the users ELO increment.
 *
 * @param gender an enum object representing a new lifters gender.
 * @param age an integer representing an existing current age.
 * @param weight a float representing an existing lifters current weight.
 * @param currentELO a float representing an existing lifters current ELO.
 * @param squatMax a float representing an existing lifters max squat.
 * @param benchMax a float representing an existing lifters max bench press.
 * @param deadLiftMax a float representing an existing lifters max deadlift.
 * @param listOfBench a lifters bench press numbers over the past three weeks.
 * @param listOfSquat a lifters squat numbers over the past three weeks.
 * @param listOfDeadlift a lifters deadlift numbers over the past three weeks.
 *
 * @author David
 */
data class UpdateELO(val gender: Gender,
                     val weight: Float,
                     val age: Int,
                     val currentELO: Int,
                     val benchMax: Float? = null,
                     val squatMax: Float? = null,
                     val deadLiftMax: Float? = null,
                     val listOfBench: List<Float>? = null,
                     val listOfSquat: List<Float>? = null,
                     val listOfDeadlift: List<Float>? = null)
