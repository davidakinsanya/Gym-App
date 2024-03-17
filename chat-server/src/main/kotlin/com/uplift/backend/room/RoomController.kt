package com.uplift.backend.room

import com.uplift.backend.data.MessageDataSource
import com.uplift.backend.data.model.Message
import io.ktor.websocket.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.util.concurrent.ConcurrentHashMap

/**
 * This class manages the chat sessions.
 *
 * @param messageDataSource an object controlling message flow.
 *
 * @author David
 */
class RoomController(
    private val messageDataSource: MessageDataSource
) {
    private val members = ConcurrentHashMap<String, Member>()

    /**
     * This method defines actions to occur as a user enters a chat room.
     *
     * @param username the name of a user.
     * @param sessionId the chat session identifier.
     * @param socket the chat socket to send messages on.
     */
    fun onJoin(
        username: String,
        sessionId: String,
        socket: WebSocketSession
    ) {
        if(members.containsKey(username)) {
            throw MemberAlreadyExistsException()
        }
        members[username] = Member(
            username = username,
            sessionId = sessionId,
            socket = socket
        )
    }

    /**
     * This function enables a user to send a message.
     *
     * @param senderUsername the username of the sender.
     * @param message the message being sent by the user.
     */
    suspend fun sendMessage(senderUsername: String, message: String) {
        members.values.forEach { member ->
            val messageEntity = Message(
                text = message,
                username = senderUsername,
                timestamp = System.currentTimeMillis()
            )
            messageDataSource.insertMessage(messageEntity)

            val parsedMessage = Json.encodeToString(messageEntity)
            member.socket.send(Frame.Text(parsedMessage))
        }
    }

    /**
     * This method retrieves all the messages in a session.
     *
     * @return a list of messages.
     */
    suspend fun getAllMessages(): List<Message> {
        return messageDataSource.getAllMessages()
    }

    /**
     * This method disconnects a user from the socket.
     *
     * @param username the name of the user.
     */
    suspend fun tryDisconnect(username: String) {
        members[username]?.socket?.close()
        if(members.containsKey(username)) {
            members.remove(username)
        }
    }
}