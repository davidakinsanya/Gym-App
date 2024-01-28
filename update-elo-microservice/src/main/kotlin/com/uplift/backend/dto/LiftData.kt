package com.uplift.backend.dto

/**
 * This enum class groups a compound lift, a standard and the prior lifts.
 *
 * @param gender the gender of the lifter.
 * @param lift the compound lift.
 * @param standard the standard of the lift completion.
 * @param currentMax the current max lift of the particular lift.
 * @param listOfLifts a list of prior lifts of the particular lift.
 *
 * @author David
 */
data class LiftData(val gender: Gender,
                    val lift: Lift,
                    val standard: Standard,
                    val currentMax: Float,
                    val listOfLifts: List<Float>)
