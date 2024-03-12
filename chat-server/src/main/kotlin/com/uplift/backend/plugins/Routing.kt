package com.uplift.backend.plugins

import com.uplift.backend.room.RoomController
import com.uplift.backend.routes.chatSocket
import com.uplift.backend.routes.getAllMessages
import io.ktor.server.application.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    val roomController by inject<RoomController>()
    install(Routing) {
        chatSocket(roomController)
        getAllMessages(roomController)
    }
}
