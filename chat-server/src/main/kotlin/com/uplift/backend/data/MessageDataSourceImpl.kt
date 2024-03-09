package com.uplift.backend.data

import com.mongodb.kotlin.client.coroutine.MongoDatabase
import com.uplift.backend.data.model.Message
import kotlinx.coroutines.flow.toList

class MessageDataSourceImpl(
    db: MongoDatabase
): MessageDataSource {

    private val messages = db.getCollection<Message>(collectionName = "messages")

    override suspend fun getAllMessages(): List<Message> {
        return messages.find()
            .toList()
            .sortedByDescending { it.timestamp }

    }

    override suspend fun insertMessage(message: Message) {
        messages.insertOne(message)
    }
}