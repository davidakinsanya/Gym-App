package com.uplift.backend.di

import com.mongodb.kotlin.client.coroutine.MongoClient
import com.uplift.backend.data.MessageDataSource
import com.uplift.backend.data.MessageDataSourceImpl
import com.uplift.backend.room.RoomController
import org.koin.dsl.module

val mainModule = module {
    single {
        MongoClient
            .create(connectionString = "mongodb+srv://davidakinsanya:34Tu3kEGvmKL6Oic@uplift-chat.hxkj1hm.mongodb.net/?retryWrites=true&w=majority&appName=uplift-chat")
            .getDatabase(databaseName = "uplift-chat")
    }
    single<MessageDataSource> {
        MessageDataSourceImpl(get())
    }
    single {
        RoomController(get())
    }
}