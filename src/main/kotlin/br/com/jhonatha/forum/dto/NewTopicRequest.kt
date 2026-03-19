package br.com.jhonatha.forum.dto

data class NewTopicRequest (
    val title: String,
    val message: String,
    val courseId: Long,
    val authorId: Long,
)
