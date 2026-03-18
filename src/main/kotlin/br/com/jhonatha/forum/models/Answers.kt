package br.com.jhonatha.forum.models

import java.time.LocalDateTime

data class Answers(
    val id: Long? = null,
    val message: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime = LocalDateTime.now(),
    val author: User,
    val topic: Topic,
    val isSolution: Boolean,
)
