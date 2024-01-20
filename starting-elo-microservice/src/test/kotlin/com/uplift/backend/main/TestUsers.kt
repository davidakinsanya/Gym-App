package com.uplift.backend.main

import com.uplift.backend.dto.Gender
import com.uplift.backend.dto.StartingELO

class TestUsers {
  
  companion object {
  
    val usr1: StartingELO = StartingELO(
      gender = Gender.MALE,
      age = 18,
      dob = listOf("01", "01", "1998"),
      weight = 55.2F,
      yearsLifting = 2,
      squatMax = 180F,
      benchMax = 95F,
      deadLiftMax = 180F
    )
  
    val usr1Heavy: StartingELO = StartingELO(
      gender = Gender.MALE,
      age = 18,
      dob = listOf("01", "01", "1998"),
      weight = 70.2F,
      yearsLifting = 2,
      squatMax = 180F,
      benchMax = 95F,
      deadLiftMax = 180F
    )
  
    val usr1Old: StartingELO = StartingELO(
      gender = Gender.MALE,
      age = 33,
      dob = listOf("01", "01", "1998"),
      weight = 55.2F,
      yearsLifting = 2,
      squatMax = 180F,
      benchMax = 95F,
      deadLiftMax = 180F
    )
  
    val usr2Female: StartingELO = StartingELO(
      gender = Gender.FEMALE,
      age = 21,
      dob = listOf("01", "01", "1998"),
      weight = 62.2F,
      yearsLifting = 2,
      squatMax = 110F,
      benchMax = 70F,
      deadLiftMax = 130F
    )
  
    val usr2FemaleHeavy: StartingELO = StartingELO(
      gender = Gender.FEMALE,
      age = 21,
      dob = listOf("01", "01", "1998"),
      weight = 72.2F,
      yearsLifting = 2,
      squatMax = 110F,
      benchMax = 70F,
      deadLiftMax = 130F
    )
  
    val usr2FemaleOld: StartingELO = StartingELO(
      gender = Gender.FEMALE,
      age = 31,
      dob = listOf("01", "01", "1998"),
      weight = 62.2F,
      yearsLifting = 2,
      squatMax = 110F,
      benchMax = 70F,
      deadLiftMax = 130F
    )
  }
}