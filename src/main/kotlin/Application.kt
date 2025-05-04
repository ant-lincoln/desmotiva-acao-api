package com.seumelhorcaminho

import com.seumelhorcaminho.routes.configureRouting
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.jetbrains.exposed.sql.Database

fun main(args: Array<String>) {
    // Verifica variáveis essenciais antes de iniciar
    val requiredVars = listOf("JDBC_URL", "DB_USER", "DB_PASSWORD")
    val missingVars = requiredVars.filter { System.getenv(it) == null }

    if (missingVars.isNotEmpty()) {
        System.err.println("ERRO: Variáveis de ambiente faltando: ${missingVars.joinToString()}")
        System.exit(1)
    }

    EngineMain.main(args)
}

fun Application.module() {
    configureHTTP()
    configureMonitoring()
    configureSerialization()

    Database.connect(
        url = System.getenv("JDBC_URL") ?: throw IllegalStateException("JDBC_URL não definido"),
        user = System.getenv("DB_USER") ?: throw IllegalStateException("DB_USER não definido"),
        password = System.getenv("DB_PASSWORD") ?: throw IllegalStateException("DB_PASSWORD não definido"),
        driver = "org.postgresql.Driver"
    )

    configureRouting()
}