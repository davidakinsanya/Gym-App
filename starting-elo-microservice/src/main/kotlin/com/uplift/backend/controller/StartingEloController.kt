package com.uplift.backend.controller

import com.uplift.backend.dao.CalculateStartingELO
import com.uplift.backend.dto.Gender
import com.uplift.backend.dto.StartingELO
import com.uplift.backend.utils.Hash
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import retrofit2.http.Query

/**
 * This class defines the endpoints for the microservice.
 *
 * @author David
 */
@RestController
class StartingEloController {
  
  /**
   * This function defines the startingELO endpoint.
   *
   * @param gender an enum object representing a new lifters gender.
   * @param age an integer representing a users current age.
   * @param weight a float representing a new lifters current weight.
   * @param squatMax a float representing a new lifters max squat.
   * @param benchMax a float representing a new lifters max bench press.
   * @param deadLiftMax a float representing a new lifters max deadlift.
   *
   * @return a list of a lifters' starting ELO and identifying hash code.
   */
  @GetMapping("/starting_elo")
  fun getStartingELO(
    @Query("gender") gender: String,
    @Query("age") age: Int,
    @Query("weight") weight: Float,
    @Query("squatMax") squatMax: Float,
    @Query("benchMax") benchMax: Float,
    @Query("deadLiftMax") deadLiftMax: Float
  ): List<String> {
    val startingELOInfo: StartingELO
    val hash: String
    
    if (gender == "MALE") {
      startingELOInfo = StartingELO(
        gender = Gender.MALE,
        age = age,
        weight = weight,
        squatMax = squatMax,
        benchMax = benchMax,
        deadLiftMax = deadLiftMax
      )
      
      hash = Hash.hash() + "-M"
    } else {
      startingELOInfo = StartingELO(
        gender = Gender.FEMALE,
        age = age,
        weight = weight,
        squatMax = squatMax,
        benchMax = benchMax,
        deadLiftMax = deadLiftMax
      )
  
      hash = Hash.hash() + "-F"
    }
    
    val calculateStartingELO = CalculateStartingELO(startingELOInfo)
    val startingELO = calculateStartingELO.calculate()
    
    return listOf(startingELO.toString(), hash)
  }
  
  /**
   * This function defines the specialty squat endpoint.
   *
   * @param gender an enum object representing a new lifters gender.
   * @param age an integer representing a users current age.
   * @param weight a float representing a new lifters current weight.
   * @param squatMax a float representing a new lifters max squat.
   *
   * @return a list of a lifters' specialty squat ELO.
   */
  @GetMapping("/specialty_squat")
  fun getSquatSpecialty(
    @Query("gender") gender: String,
    @Query("age") age: Int,
    @Query("weight") weight: Float,
    @Query("squatMax") squatMax: Float,
  ): Int {
  
    val startingELOInfo: StartingELO = if (gender == "MALE") {
      StartingELO(
        gender = Gender.MALE,
        age = age,
        weight = weight,
        squatMax = squatMax
      )
    } else {
      StartingELO(
        gender = Gender.FEMALE,
        age = age,
        weight = weight,
        squatMax = squatMax
      )
    }
  
    val calculateStartingELO = CalculateStartingELO(startingELOInfo)
    return calculateStartingELO.calculateSquatSpecialty()
  }
  
  /**
   * This function defines the specialty bench endpoint.
   *
   * @param gender an enum object representing a new lifters gender.
   * @param age an integer representing a users current age.
   * @param weight a float representing a new lifters current weight.
   * @param benchMax a float representing a new lifters max bench press.
   *
   * @return a list of a lifters' specialty bench ELO.
   */
  @GetMapping("/specialty_bench")
  fun getBenchSpeciality(
    @Query("gender") gender: String,
    @Query("age") age: Int,
    @Query("weight") weight: Float,
    @Query("benchMax") benchMax: Float,
  ): Int {
  
    val startingELOInfo: StartingELO = if (gender == "MALE") {
      StartingELO(
        gender = Gender.MALE,
        age = age,
        weight = weight,
        benchMax = benchMax
      )
    } else {
      StartingELO(
        gender = Gender.FEMALE,
        age = age,
        weight = weight,
        benchMax = benchMax
      )
    }
  
    val calculateStartingELO = CalculateStartingELO(startingELOInfo)
    return calculateStartingELO.calculateBenchSpecialty()
  }
  
  /**
   * This function defines the specialty deadlift endpoint.
   *
   * @param gender an enum object representing a new lifters gender.
   * @param age an integer representing a users current age.
   * @param weight a float representing a new lifters current weight.
   * @param deadLiftMax a float representing a new lifters max deadlift.
   *
   * @return a list of a lifters' specialty deadlift ELO.
   */
  @GetMapping("/specialty_deadlift")
  fun getDeadliftSpecialty(@Query("gender") gender: String,
                           @Query("age") age: Int,
                           @Query("weight") weight: Float,
                           @Query("deadLiftMax") deadLiftMax: Float): Int {
    
    val startingELOInfo: StartingELO = if (gender == "MALE") {
      StartingELO(
        gender = Gender.MALE,
        age = age,
        weight = weight,
        deadLiftMax = deadLiftMax
      )
    } else {
      StartingELO(
        gender = Gender.FEMALE,
        age = age,
        weight = weight,
        deadLiftMax = deadLiftMax
      )
    }
  
    val calculateStartingELO = CalculateStartingELO(startingELOInfo)
    return calculateStartingELO.calculateDeadliftSpecialty()
  }
}