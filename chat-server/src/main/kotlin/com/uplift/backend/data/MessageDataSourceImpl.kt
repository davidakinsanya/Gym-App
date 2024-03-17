package com.uplift.backend.data

import com.mongodb.kotlin.client.coroutine.MongoDatabase
import com.uplift.backend.data.model.Message
import kotlinx.coroutines.flow.toList

/**
 * This class implements on the functionalities of a message controller.
 *
 * @param db a database instance.
 *
 * @author David
 *
 */
class MessageDataSourceImpl(
    db: MongoDatabase
): MessageDataSource {

    private val messages = db.getCollection<Message>(collectionName = "messages")

    /**
     * This method retrieves all the messages in a session.
     *
     * @return a list of messages.
     */
    override suspend fun getAllMessages(): List<Message> {
        return messages.find()
            .toList()
            .sortedByDescending { it.timestamp }

    }

    /**
     * This method inserts a message in a session.
     *
     * @param message a recent user message.
     */
    override suspend fun insertMessage(message: Message) {
        messages.insertOne(message)
    }
}