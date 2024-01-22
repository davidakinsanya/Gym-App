package com.uplift.backend.dto

/**
 * This data class defines the information we take from new lifters
 * to determine the users starting ELO.
 *
 * @param gender an enum object representing a new lifters gender.
 * @param age an integer representing a users current age.
 * @param weight a float representing a new lifters current weight.
 * @param squatMax a float representing a new lifters max squat.
 * @param benchMax a float representing a new lifters max bench press.
 * @param deadLiftMax a float representing a new lifters max deadlift.
 *
 * @author David
 */
data class StartingELO (val gender: Gender,
                        val age: Int,
                        val weight: Float,
                        val squatMax: Float,
                        val benchMax: Float,
                        val deadLiftMax: Float)