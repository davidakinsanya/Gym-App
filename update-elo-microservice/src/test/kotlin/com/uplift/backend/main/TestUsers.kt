package com.uplift.backend.main

import com.uplift.backend.dto.Gender
import com.uplift.backend.dto.UpdateELO

/**
 * This class outlines a number of test users to
 * test the functions of the microservice.
 *
 * @author David
 */
class TestUsers {
  
  companion object {
    val usr1 = UpdateELO(
      gender = Gender.MALE,
      age = 18,
      weight = 55.2F,
      squatMax = 180F,
      benchMax = 95F,
      deadLiftMax = 180F,
      currentELO = 1680,
      listOfBench = listOf((55.2F * 1.65).toFloat(), (55.2F * 1.7).toFloat(), (55.2F * 1.69).toFloat()),
      listOfSquat = listOf((55.2F * 3.01).toFloat(), (55.2F * 3.07).toFloat(), (55.2F * 3.1).toFloat()),
      listOfDeadlift = listOf((55.2F * 3.01).toFloat(), (55.2F * 3.07).toFloat(), (55.2F * 3.1).toFloat()))
  
    val usr1Heavy = UpdateELO(
      gender = Gender.MALE,
      age = 18,
      weight = 70.2F,
      squatMax = 180F,
      benchMax = 95F,
      deadLiftMax = 180F,
      currentELO = 1606,
      listOfBench = listOf((70.2F * 1.4).toFloat(), (70.2F * 1.41).toFloat(), (70.2F * 1.69).toFloat()),
      listOfSquat = listOf((70.2F * 2.51).toFloat(), (70.2F * 2.57).toFloat(), (70.2F * 2.51).toFloat()),
      listOfDeadlift = listOf((70.2F * 2.51).toFloat(), (70.2F * 2.57).toFloat(), (70.2F * 2.51).toFloat()))
  }
}