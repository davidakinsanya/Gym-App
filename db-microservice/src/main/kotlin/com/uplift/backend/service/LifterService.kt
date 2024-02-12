package com.uplift.backend.service

import com.uplift.backend.table.Lifter
import java.util.*

interface LifterService {
  
  fun getAllLifters(): List<Lifter>
  fun getLifterByID(id: String): Optional<Lifter>
  fun addLifter(id: String, elo: Int, region: String, isPremium: Boolean)
  fun deleteLifter(id: String)
  fun updateELO(lifter: Lifter)
}