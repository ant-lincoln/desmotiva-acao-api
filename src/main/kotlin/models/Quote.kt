
package com.seumelhorcaminho.models

import kotlinx.serialization.Serializable

@Serializable
data class Quote(
    val id: Int,
    val text: String,
    val author: String
)
