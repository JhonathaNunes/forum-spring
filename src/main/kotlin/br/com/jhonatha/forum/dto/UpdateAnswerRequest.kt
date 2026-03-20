package br.com.jhonatha.forum.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class UpdateAnswerRequest (
    @field:NotNull
    val id: Long,
    @field:NotEmpty
    @field:Size(min = 10)
    val message: String
)
