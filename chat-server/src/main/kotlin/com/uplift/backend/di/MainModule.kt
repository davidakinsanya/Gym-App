package com.uplift.backend.di

import com.mongodb.kotlin.client.coroutine.MongoClient
import com.uplift.backend.data.MessageDataSource
import com.uplift.backend.data.MessageDataSourceImpl
import com.uplift.backend.room.RoomController
import org.koin.dsl.module

val mainModule = module {
    single {
        MongoClient
            .create(connectionString = "mongodb://")
            .getDatabase(databaseName = "Uplift-Chat")
    }
    single<MessageDataSource> {
        MessageDataSourceImpl(get())
    }
    single {
        RoomController(get())
    }
}