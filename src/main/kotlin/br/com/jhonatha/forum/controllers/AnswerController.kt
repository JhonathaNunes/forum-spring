package br.com.jhonatha.forum.controllers

import br.com.jhonatha.forum.dto.AnswersResponse
import br.com.jhonatha.forum.dto.NewAnswerRequest
import br.com.jhonatha.forum.dto.toAnswersResponse
import br.com.jhonatha.forum.services.AnswerService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/topics/{id}/answers")
class AnswerController(
    private val answerService: AnswerService
) {
    @GetMapping
    fun getAnswersFromTopic(@PathVariable id: Long): List<AnswersResponse> {
        return answerService.getAnswersFromTopic(id)
            .map { it.toAnswersResponse() }
    }

    @PostMapping
    fun createAnswer(
        @PathVariable id: Long,
        @RequestBody request: NewAnswerRequest
    ) {
        answerService.create(id, request)
    }
}