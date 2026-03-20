package br.com.jhonatha.forum.controllers

import br.com.jhonatha.forum.dto.AnswerResponse
import br.com.jhonatha.forum.dto.NewAnswerRequest
import br.com.jhonatha.forum.dto.UpdateAnswerRequest
import br.com.jhonatha.forum.dto.toAnswersResponse
import br.com.jhonatha.forum.services.AnswerService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/topics/{topicId}/answers")
class AnswerController(
    private val answerService: AnswerService
) {
    @GetMapping
    fun getAnswersFromTopic(@PathVariable topicId: Long): List<AnswerResponse> {
        return answerService.getAnswersFromTopic(topicId)
            .map { it.toAnswersResponse() }
    }

    @PostMapping
    fun createAnswer(
        @PathVariable topicId: Long,
        @RequestBody @Valid request: NewAnswerRequest,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<AnswerResponse> {
        val response = answerService.create(topicId, request).toAnswersResponse()
        val uri = uriBuilder.path("/topics/${topicId}/answers").build().toUri()

        return ResponseEntity.created(uri).body(response)
    }

    @PutMapping
    fun updateAnswer(
        @RequestBody @Valid request: UpdateAnswerRequest,
    ): ResponseEntity<AnswerResponse> {
        val response = answerService.update(request).toAnswersResponse()

        return ResponseEntity.ok(response)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteAnswer(@PathVariable id: Long) {
        answerService.delete(id)
    }
}