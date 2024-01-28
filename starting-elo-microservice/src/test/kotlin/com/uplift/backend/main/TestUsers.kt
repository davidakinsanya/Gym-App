package com.uplift.backend.main

import com.uplift.backend.dto.Gender
import com.uplift.backend.dto.StartingELO

/**
 * This class outlines a number of test users to
 * test the functions of the microservice.
 *
 * @author David
 */
class TestUsers {
  
  companion object {
  
    val usr1: StartingELO = StartingELO(
      gender = Gender.MALE,
      age = 18,
      weight = 55.2F,
      squatMax = 180F,
      benchMax = 95F,
      deadLiftMax = 180F
    )
  
    val usr1Heavy: StartingELO = StartingELO(
      gender = Gender.MALE,
      age = 18,
      weight = 70.2F,
      squatMax = 180F,
      benchMax = 95F,
      deadLiftMax = 180F
    )
  
    val usr1Old: StartingELO = StartingELO(
      gender = Gender.MALE,
      age = 33,
      weight = 55.2F,
      squatMax = 180F,
      benchMax = 95F,
      deadLiftMax = 180F
    )
  
    val usr2Female: StartingELO = StartingELO(
      gender = Gender.FEMALE,
      age = 21,
      weight = 62.2F,
      squatMax = 110F,
      benchMax = 70F,
      deadLiftMax = 130F
    )
  
    val usr2FemaleHeavy: StartingELO = StartingELO(
      gender = Gender.FEMALE,
      age = 21,
      weight = 72.2F,
      squatMax = 110F,
      benchMax = 70F,
      deadLiftMax = 130F
    )
  
    val usr2FemaleOld: StartingELO = StartingELO(
      gender = Gender.FEMALE,
      age = 31,
      weight = 62.2F,
      squatMax = 110F,
      benchMax = 70F,
      deadLiftMax = 130F
    )
  }
}