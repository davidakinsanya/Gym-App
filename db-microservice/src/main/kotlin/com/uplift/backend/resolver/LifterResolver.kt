package com.uplift.backend.resolver

import com.uplift.backend.service.LifterService
import com.uplift.backend.service.impl.LifterServiceImpl
import com.uplift.backend.table.Lifter
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller
import java.util.*

/**
 * This class defines the endpoints for the microservice.
 *
 * @param lifterImpl an LifterServiceImpl object.
 *
 * @author David
 */
@Controller
class LifterResolver(private val lifterImpl: LifterServiceImpl): LifterService {
  
  /**
   * This method retrieves all the lifters in the database.
   *
   * @return a list of lifters on the platform.
   */
  @QueryMapping
  override fun getAllLifters(): List<Lifter> {
    return lifterImpl.getAllLifters()
  }
  
  /**
   * This method retrieves a specific lifter on the platform.
   *
   * @return a specific lifter.
   */
  @QueryMapping
  override fun getLifterByID(@Argument id: String): Optional<Lifter> {
    return lifterImpl.getLifterByID(id)
  }
  
  /**
   * This method adds a new lifter to the database.
   */
  @MutationMapping
  override fun addLifter(@Argument id: String,
                         @Argument elo: Int,
                         @Argument region: String,
                         @Argument isPremium: Boolean) {
    
    return lifterImpl.addLifter(id, elo, region, isPremium)
  }
  
  /**
   * This method deletes a specific lifter from the database.
   */
  @MutationMapping
  override fun deleteLifter(@Argument id: String) {
    return lifterImpl.deleteLifter(id)
  }
  
  /**
   * This method updates a lifters ELO rating.
   */
  @MutationMapping
  override fun updateELO(@Argument lifter: Lifter) {
    return lifterImpl.updateELO(lifter)
  }
}