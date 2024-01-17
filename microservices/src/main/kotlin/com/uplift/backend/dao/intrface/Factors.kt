package com.uplift.backend.dao.intrface

import dto.StartingELO

interface Factors {
  
  fun addBenchFactors(currentELO: Int,
                      startingELO: StartingELO,
                      currentWeight: Float): Int
  
  fun addSquatFactors(currentELO: Int,
                      startingELO: StartingELO,
                      currentWeight: Float): Int
  
  fun addDeadLiftFactors(currentELO: Int,
                         startingELO: StartingELO,
                         currentWeight: Float): Int
  
}