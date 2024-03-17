package com.uplift.backend.data.model

import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

/**
 * This class contains the data surrounding messages.
 *
 * @param text the contents of the users message.
 * @param username the name of the user.
 * @param timestamp the time in which the message was sent.
 *
 * @param id an object identifier.
 *
 * @author David
 */
@Serializable
data class Message(
    val text: String,
    val username: String,
    val timestamp: Long,
    @BsonId
    val id: String = ObjectId().toString()
)
