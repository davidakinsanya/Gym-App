package com.backend.uplift.main

import com.backend.uplift.di.mainModule
import com.backend.uplift.plugins.*
import com.backend.uplift.utils.TokenManager
import io.ktor.server.application.*
import io.ktor.server.config.*
import org.koin.core.context.GlobalContext.get
import org.koin.ktor.ext.inject
import org.koin.ktor.plugin.Koin

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    val tokenManager by inject<TokenManager>()
    val config by inject<HoconApplicationConfig>()
    
    install(Koin) {
        modules(mainModule)
    }
    
    configureAuth(tokenManager, config)
    configureSerialization()
    configureRouting(tokenManager)
}
