package com.uplift.backend.dto

/**
 * This enum class groups a compound lift, a standard and the prior lifts.
 *
 * @author David
 */
data class LiftData(val gender: Gender,
                    val lift: Lift,
                    val standard: Standard,
                    val listOfLifts: List<Float>)
