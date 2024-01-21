package com.uplift.backend.dto

/**
 * This data class defines the information we take from new lifters
 * to determine the users starting ELO.
 *
 * @param gender an enum object representing a new lifters gender.
 * @param age an integer representing a users current age.
 * @param dob a list of strings representing a new lifters date of birth.
 * @param weight a float representing a new lifters current weight.
 * @param yearsLifting an integer representing a how many years a new lifter
 *                     (on the platform) has been lifting for.
 * @param squatMax a float representing a new lifters max squat.
 * @param benchMax a float representing a new lifters max bench press.
 * @param deadLiftMax a float representing a new lifters max deadlift.
 *
 * @author David
 */
data class StartingELO (val gender: Gender,
                        val age: Int,
                        val dob: List<String>,
                        val weight: Float,
                        val yearsLifting: Int,
                        val squatMax: Float,
                        val benchMax: Float,
                        val deadLiftMax: Float)