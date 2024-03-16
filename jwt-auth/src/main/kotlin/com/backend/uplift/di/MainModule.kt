package com.backend.uplift.di

import com.backend.uplift.utils.TokenManager
import com.typesafe.config.ConfigFactory
import io.ktor.server.config.*
import org.koin.dsl.module
import java.io.File

val mainModule = module {
  single {
    File(System.getProperty("user.dir") + "/src/main/resources/auth.conf")
  }
  
  single {
    HoconApplicationConfig(ConfigFactory.parseFile(get()))
  }
  
  single {
    TokenManager(get())
  }
}