package com.uplift.backend.dto

import dto.Gender

data class StartingELO (val gender: Gender,
                        val age: Int,
                        val dob: List<String>,
                        val weight: Float,
                        val yearsLifting: Int,
                        val squatMax: Float,
                        val benchMax: Float,
                        val deadLiftMax: Float)