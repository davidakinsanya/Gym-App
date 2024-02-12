package com.uplift.backend.repository

import com.uplift.backend.table.Lifter
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * This interface controls the CRUD operations for the database microservice.
 *
 * @author David
 */
@Repository
interface LifterRepository: JpaRepository<Lifter, String> {

}