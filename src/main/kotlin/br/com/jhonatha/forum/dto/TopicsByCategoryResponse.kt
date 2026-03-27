package br.com.jhonatha.forum.dto

data class TopicsByCategoryResponse(
    val category: String,
    val topicsCount: Long
)