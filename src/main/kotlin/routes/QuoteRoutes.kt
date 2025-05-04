package com.seumelhorcaminho.routes

import com.seumelhorcaminho.models.Quote
import com.seumelhorcaminho.models.Quotes
import io.ktor.http.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

fun Route.quoteRoutes() {
    route("/quote") {
        get {
            val limit = call.request.queryParameters["limit"]?.toIntOrNull()?.coerceIn(1, 20) ?: 1
            val author = call.request.queryParameters["author"]

            val quotes = transaction {
                val query = if (author != null) {
                    Quotes.select { Quotes.author eq author }
                } else {
                    Quotes.selectAll()
                }

                query.shuffled().take(limit).map {
                    Quote(
                        id = it[Quotes.id],
                        text = it[Quotes.text],
                        author = it[Quotes.author]
                    )
                }
            }

            // Aqui fica o tratamento da ausência de resultados:
            if (quotes.isEmpty()) {
                call.respond(
                    HttpStatusCode.OK,
                    mapOf("message" to "Nenhuma citação encontrada para os parâmetros informados.")
                )
            } else {
                call.respond(quotes)
            }
        }
    }
}

