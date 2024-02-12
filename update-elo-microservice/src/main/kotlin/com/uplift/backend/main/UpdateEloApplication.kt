package com.uplift.backend.main

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * This class is the entry point to the microservice.
 *
 * @author David
 */
@SpringBootApplication
class UpdateEloApplication

/**
 * This function is the main method tasked with running
 * the microservice.
 *
 * @param args an array of strings representing
 *             the command line arguments.
 */
fun main(args: Array<String>) {
	runApplication<UpdateEloApplication>(*args)
}
