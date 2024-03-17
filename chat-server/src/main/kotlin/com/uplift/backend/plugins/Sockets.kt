package com.uplift.backend.plugins

import java.time.*
import io.ktor.server.application.*
import io.ktor.server.websocket.*

/**
 * This method configures web sockets in the server.
 */
fun Application.configureSockets() {
    install(WebSockets) {
        pingPeriod = Duration.ofSeconds(15)
        timeout = Duration.ofSeconds(15)
        maxFrameSize = Long.MAX_VALUE
        masking = false
    }
}
