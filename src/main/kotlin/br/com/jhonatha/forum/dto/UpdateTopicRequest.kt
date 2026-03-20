package br.com.jhonatha.forum.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class UpdateTopicRequest(
    @field:NotNull
    val id: Long,
    @field:NotEmpty
    @field:Size(min = 5, max = 50)
    val title: String,
    @field:NotEmpty
    val message: String,
)
