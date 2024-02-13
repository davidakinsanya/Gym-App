package com.uplift.backend.table

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

/**
 * This class defines a table for all the lifters on the platform.
 *
 * @param id a string representing a lifter's id.
 * @param elo an integer representing a lifter's ELO rating.
 * @param region a string representing a lifter's region.
 * @param isPremium a boolean representing whether a lifter is a premium user.
 *
 * @author David
 */
@Table(name = "Lifter")
@Entity
class Lifter (
  @Id
  private val id: String = "",
  @Column(nullable = false)
  private val elo: Int = 0,
  @Column(nullable = false)
  private val region: String = "",
  @Column(nullable = false)
  private val isPremium: Boolean = false

) {
  
  /**
   * This method retrieves a lifter's id.
   *
   * @return a string representing a lifter's id.
   */
  fun getID(): String {
    return id
  }
  
  /**
   * This method retrieves a lifter's ELO rating.
   *
   * @return an integer representing a lifter's ELO rating.
   */
  fun getELO(): Int {
    return elo
  }
  
  /**
   * This method retrieves a lifter's region.
   *
   * @return a string representing a lifter's region.
   */
  fun getRegion(): String {
    return region
  }
  
  /**
   * This method retrieves a lifter's premium status.
   *
   * @return a boolean representing whether a lifter is a premium user.
   */
  fun getIsPremium(): Boolean {
    return isPremium
  }
}
  
