package com.uplift.backend.controller

import com.uplift.backend.dao.CalculateUpdateELO
import com.uplift.backend.dto.Gender
import com.uplift.backend.dto.UpdateELO
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import retrofit2.http.Query

/**
 * This class defines the endpoints for the microservice.
 *
 * @author David
 */
@RestController
class UpdateEloController {
  
  /**
   * This function defines the updateElo endpoint.
   *
   * @param gender an enum object representing a new lifters gender.
   * @param age an integer representing a users current age.
   * @param weight a float representing a new lifters current weight.
   *  @param currentELO a float representing an existing lifters current ELO.
   * @param squatMax a float representing a new lifters max squat.
   * @param benchMax a float representing a new lifters max bench press.
   * @param deadLiftMax a float representing an existing lifters max deadlift.
   * @param listOfBench a lifters bench press numbers over the past three weeks.
   * @param listOfSquat a lifters squat numbers over the past three weeks.
   * @param listOfDeadlift a lifters deadlift numbers over the past three weeks.
   *
   * @return an existing lifters' updated ELO.
   */
  @GetMapping("/update_elo")
  fun getStartingELO(
    @Query("gender") gender: Gender,
    @Query("age") age: Int,
    @Query("weight") weight: Float,
    @Query("currentELO") currentELO: Int,
    @Query("squatMax") squatMax: Float,
    @Query("benchMax") benchMax: Float,
    @Query("deadLiftMax") deadLiftMax: Float,
    @Query("listOfBench") listOfBench: List<Float>,
    @Query("listOfSquat") listOfSquat: List<Float>,
    @Query("listOfDeadlift") listOfDeadlift: List<Float>
  ): Int {
    
    val data = UpdateELO(gender = gender, age = age, weight = weight,
                         currentELO = currentELO, squatMax = squatMax, benchMax = benchMax,
                         deadLiftMax = deadLiftMax, listOfBench = listOfBench, listOfSquat = listOfSquat,
                         listOfDeadlift = listOfDeadlift)
    
    return CalculateUpdateELO(data).calculate()
  }
  
  /**
   * This function defines the squat specialty endpoint.
   *
   * @param gender an enum object representing a new lifters gender.
   * @param age an integer representing a users current age.
   * @param weight a float representing a new lifters current weight.
   *  @param currentELO a float representing an existing lifters current ELO.
   * @param squatMax a float representing a new lifters max squat.
   * @param listOfSquat a lifters squat numbers over the past three weeks.
   *
   * @return an existing lifters' updated ELO.
   */
  @GetMapping("/update_specialty_squat")
  fun getSquatSpecialty(
    @Query("gender") gender: Gender,
    @Query("age") age: Int,
    @Query("weight") weight: Float,
    @Query("currentELO") currentELO: Int,
    @Query("squatMax") squatMax: Float,
    @Query("listOfSquat") listOfSquat: List<Float>
  ): Int {
    
    val data = UpdateELO(gender = gender, age = age, weight = weight,
      currentELO = currentELO, squatMax = squatMax,
      listOfSquat = listOfSquat)
    
    return CalculateUpdateELO(data).calculateSquatSpecialty()
  }
  
  /**
   * This function defines the bench specialty endpoint.
   *
   * @param gender an enum object representing a new lifters gender.
   * @param age an integer representing a users current age.
   * @param weight a float representing a new lifters current weight.
   *  @param currentELO a float representing an existing lifters current ELO.
   * @param benchMax a float representing a new lifters max bench press.ft.
   * @param listOfBench a lifters bench press numbers over the past three weeks.
   *
   * @return an existing lifters' updated ELO.
   */
  @GetMapping("/update_specialty_bench")
  fun getBenchSpecialty(
    @Query("gender") gender: Gender,
    @Query("age") age: Int,
    @Query("weight") weight: Float,
    @Query("currentELO") currentELO: Int,
    @Query("benchMax") benchMax: Float,
    @Query("listOfBench") listOfBench: List<Float>,
  ): Int {
    val data = UpdateELO(gender = gender, age = age, weight = weight,
      currentELO = currentELO, benchMax = benchMax,
      listOfBench = listOfBench)
    
    return CalculateUpdateELO(data).calculateBenchSpecialty()
  }

/**
 * This function defines the deadlift specialty endpoint.
 *
 * @param gender an enum object representing a new lifters gender.
 * @param age an integer representing a users current age.
 * @param weight a float representing a new lifters current weight.
 *  @param currentELO a float representing an existing lifters current ELO.
 * @param deadLiftMax a float representing an existing lifters max deadlift.
 * @param listOfDeadlift a lifters deadlift numbers over the past three weeks.
 *
 * @return an existing lifters' updated ELO.
 *
 */
  @GetMapping("/update_specialty_deadlift")
  fun getDeadliftSpecialty(
    @Query("gender") gender: Gender,
    @Query("age") age: Int,
    @Query("weight") weight: Float,
    @Query("currentELO") currentELO: Int,
    @Query("deadLiftMax") deadLiftMax: Float,
    @Query("listOfDeadlift") listOfDeadlift: List<Float>
  ): Int {
  
    val data = UpdateELO(gender = gender, age = age, weight = weight,
      currentELO = currentELO, deadLiftMax = deadLiftMax,
      listOfDeadlift = listOfDeadlift)
    
    return CalculateUpdateELO(data).calculateDeadliftSpecialty()
  }
}