package com.uplift.backend.service.impl

import com.uplift.backend.repository.LifterRepository
import com.uplift.backend.service.LifterService
import com.uplift.backend.table.Lifter
import java.util.*

/**
 * This interface defines the functionality behind all database operations for the microservice.
 *
 * @param lifterRepository an object controlling the microservices CRUD operations.
 *
 * @author David
 */
class LifterServiceImpl(
  private val lifterRepository: LifterRepository
  ) : LifterService {
  
  /**
   * This method retrieves all the lifters in the database.
   *
   * @return a list of lifters on the platform.
   */
  override fun getAllLifters(): List<Lifter> {
    return lifterRepository.findAll()
  }
  
  /**
   * This method retrieves a specific lifter on the platform.
   *
   * @return a specific lifter.
   */
  override fun getLifterByID(id: String): Optional<Lifter> {
    return lifterRepository.findById(id)
  }
  
  /**
   * This method adds a new lifter to the database.
   */
  override fun addLifter(id: String, elo: Int, region: String, isPremium: Boolean) {
    lifterRepository.save(Lifter(id, elo, region, isPremium))
  }
  
  /**
   * This method deletes a specific lifter from the database.
   */
  override fun deleteLifter(id: String) {
    lifterRepository.deleteById(id)
  }
  
  /**
   * This method updates a lifters ELO rating.
   */
  override fun updateELO(lifter: Lifter) {
    lifterRepository.save(lifter)
  }
}