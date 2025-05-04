package com.seumelhorcaminho

import com.seumelhorcaminho.routes.configureRouting
import com.seumelhorcaminho.routes.quoteRoutes
import io.ktor.server.application.*
import io.ktor.server.routing.*
import org.jetbrains.exposed.sql.Database

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureHTTP()
    configureMonitoring()
    configureSerialization()

    val config = environment.config

    Database.connect(
        url = config.property("storage.jdbcURL").getString(),
        driver =  config.property("storage.driverClassName").getString(),
        user = config.property("storage.user").getString(),
        password = config.property("storage.password").getString(),
    )

    configureRouting()
}

