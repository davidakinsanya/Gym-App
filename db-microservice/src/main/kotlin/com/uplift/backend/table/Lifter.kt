package com.uplift.backend.table

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

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
  
  fun getID(): String {
    return id
  }
  
  fun getELO(): Int {
    return elo
  }
  
  fun getRegion(): String {
    return region
  }
  
  fun getIsPremium(): Boolean {
    return isPremium
  }
}
  
