package br.com.jhonatha.forum.dto

import br.com.jhonatha.forum.models.TopicStatus
import java.time.LocalDateTime

data class TopicResponse(
    val id: Long,
    val title: String,
    val message: String,
    val status: TopicStatus,
    val createdAt: LocalDateTime,
)
