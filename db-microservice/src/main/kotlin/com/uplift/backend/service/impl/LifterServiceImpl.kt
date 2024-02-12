package com.uplift.backend.service.impl

import com.uplift.backend.repository.LifterRepository
import com.uplift.backend.service.LifterService
import com.uplift.backend.table.Lifter
import java.util.*

class LifterServiceImpl(
  private val lifterRepository: LifterRepository
  ) : LifterService {
  
  override fun getAllLifters(): List<Lifter> {
    return lifterRepository.findAll()
  }
  
  override fun getLifterByID(id: String): Optional<Lifter> {
    return lifterRepository.findById(id)
  }
  
  override fun addLifter(id: String, elo: Int, region: String, isPremium: Boolean) {
    lifterRepository.save(Lifter(id, elo, region, isPremium))
  }
  
  override fun deleteLifter(id: String) {
    lifterRepository.deleteById(id)
  }
  
  override fun updateELO(lifter: Lifter) {
    lifterRepository.save(lifter)
  }
}