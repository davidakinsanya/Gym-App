package com.uplift.backend.session

/**
 * This class defines a user within a chat session.
 *
 * @param username the name of a user.
 * @param sessionId a chat session identifier.
 *
 * @author David.
 */
data class ChatSession(
    val username: String,
    val sessionId: String
)
