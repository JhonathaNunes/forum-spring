package br.com.jhonatha.forum.dto

import br.com.jhonatha.forum.models.Answer

fun Answer.toAnswersResponse(): AnswersResponse {
    return AnswersResponse(
        id = this.id ?: 0,
        message = this.message,
        topicId = this.topic.id ?: 0,
        isSolution = this.isSolution
    )
}

data class AnswersResponse(
    val id: Long,
    val message: String,
    val topicId: Long,
    val isSolution: Boolean
)