package com.uplift.backend.main

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class StartingEloApplication

fun main(args: Array<String>) {
	runApplication<StartingEloApplication>(*args)
}
