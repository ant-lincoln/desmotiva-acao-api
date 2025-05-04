package com.seumelhorcaminho.routes

import com.seumelhorcaminho.models.Quote
import com.seumelhorcaminho.models.Quotes
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Seja mal vindo ao mundo desmotivacional! Lembre-se que nesse exato momento há alguém fazendo em um dia o que você faz no mês ;)")
        }
        get("/health") {
            call.respondText("OK")
        }

        quoteRoutes()
    }
}