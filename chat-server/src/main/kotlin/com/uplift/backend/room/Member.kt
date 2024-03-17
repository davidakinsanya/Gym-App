package com.uplift.backend.room

import io.ktor.websocket.*

/**
 * This class outlines a member in a chat session.
 *
 * @param username the name of the user.
 * @param sessionId the chat session identifier.
 * @param socket the chat socket the member is in.
 *
 * @author David
 */
data class Member(
    val username: String,
    val sessionId: String,
    val socket: WebSocketSession
)
