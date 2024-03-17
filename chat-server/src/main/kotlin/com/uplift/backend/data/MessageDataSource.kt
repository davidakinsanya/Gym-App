package com.uplift.backend.data

import com.uplift.backend.data.model.Message

/**
 * This interface outlines the functionalities of a message controller.
 *
 * @author David
 */
interface MessageDataSource {

    /**
     * This method retrieves all the messages in a session.
     *
     * @return a list of messages.
     */
    suspend fun getAllMessages(): List<Message>

    /**
     * This method inserts a message in a session.
     *
     * @param message a recent user message.
     */
    suspend fun insertMessage(message: Message)
}