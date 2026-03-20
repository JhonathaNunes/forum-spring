package br.com.jhonatha.forum.dto

data class NewAnswerRequest (
    val message: String,
    val authorId: Long,
)
