package br.com.jhonatha.forum.dto

import br.com.jhonatha.forum.models.Topic
import br.com.jhonatha.forum.models.TopicStatus
import java.time.LocalDateTime

fun Topic.toTopicResponse(): TopicResponse {
    return TopicResponse(
        id = this.id ?: 0,
        title = this.title,
        message = this.message,
        status = this.status,
        createdAt = this.createdAt
    )
}

data class TopicResponse(
    val id: Long,
    val title: String,
    val message: String,
    val status: TopicStatus,
    val createdAt: LocalDateTime,
)
