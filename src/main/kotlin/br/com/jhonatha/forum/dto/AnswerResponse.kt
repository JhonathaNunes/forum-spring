package br.com.jhonatha.forum.dto

import br.com.jhonatha.forum.models.Answer

fun Answer.toAnswersResponse(): AnswerResponse {
    return AnswerResponse(
        id = this.id ?: 0,
        message = this.message,
        topicId = this.topic.id ?: 0,
        isSolution = this.isSolution
    )
}

data class AnswerResponse(
    val id: Long,
    val message: String,
    val topicId: Long,
    val isSolution: Boolean
)