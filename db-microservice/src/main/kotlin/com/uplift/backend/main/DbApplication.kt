package com.uplift.backend.main

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DbMicroserviceApplication

fun main(args: Array<String>) {
	runApplication<DbMicroserviceApplication>(*args)
}
