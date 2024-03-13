package com.uplift.backend.di

import com.mongodb.kotlin.client.coroutine.MongoClient
import com.typesafe.config.ConfigFactory
import com.uplift.backend.data.MessageDataSource
import com.uplift.backend.data.MessageDataSourceImpl
import com.uplift.backend.room.RoomController
import de.sharpmind.ktor.EnvConfig
import io.ktor.server.config.*
import org.koin.dsl.module
import java.io.File

val file = File(System.getProperty("user.dir") + "/src/main/resources/connection.conf")
val config = HoconApplicationConfig(
    ConfigFactory.parseFile(file)
)

val mainModule = module {
    single {
        MongoClient
            .create(connectionString = EnvConfig.initConfig(config).getString("conn"))
            .getDatabase(databaseName = "uplift-chat")
    }
    single<MessageDataSource> {
        MessageDataSourceImpl(get())
    }
    single {
        RoomController(get())
    }
}