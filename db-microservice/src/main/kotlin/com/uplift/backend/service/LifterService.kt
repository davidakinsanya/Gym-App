package com.uplift.backend.service

import com.uplift.backend.table.Lifter
import java.util.*

/**
 * This interface defines all the database operations for the microservice.
 *
 * @author David
 */
interface LifterService {
  
  /**
   * This method retrieves all the lifters in the database.
   *
   * @return a list of lifters on the platform.
   */
  fun getAllLifters(): List<Lifter>
  
  /**
   * This method retrieves a specific lifter on the platform.
   *
   * @return a specific lifter.
   */
  fun getLifterByID(id: String): Optional<Lifter>
  
  /**
   * This method adds a new lifter to the database.
   */
  fun addLifter(id: String, elo: Int, region: String, isPremium: Boolean)
  
  /**
   * This method deletes a specific lifter from the database.
   */
  fun deleteLifter(id: String)
  
  /**
   * This method updates a lifters ELO rating.
   */
  fun updateELO(lifter: Lifter)
}