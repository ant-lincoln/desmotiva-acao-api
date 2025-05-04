// src/main/kotlin/com/seumelhorcaminho/models/QuotesTable.kt

package com.seumelhorcaminho.models

import org.jetbrains.exposed.sql.Table

object Quotes : Table("quotes") {
    val id = integer("id").autoIncrement()
    val text = varchar("text", 620)
    val author = varchar("author", 128)

    override val primaryKey = PrimaryKey(id, name = "pk_quotes_id") }
