package br.com.jhonatha.forum.controllers

import br.com.jhonatha.forum.dto.NewTopicRequest
import br.com.jhonatha.forum.dto.TopicResponse
import br.com.jhonatha.forum.dto.UpdateTopicRequest
import br.com.jhonatha.forum.dto.toTopicResponse
import br.com.jhonatha.forum.services.TopicService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/topics")
class TopicController(private val service: TopicService) {

    @GetMapping
    fun getAllTopics(): List<TopicResponse> {
        return service.list().map {
            it.toTopicResponse()
        }
    }

    @GetMapping("/{id}")
    fun getTopicById(@PathVariable id: Long): TopicResponse {
        return service.findById(id).toTopicResponse()
    }

    @PostMapping
    fun createTopic(@RequestBody @Valid request: NewTopicRequest) {
        service.create(request)
    }

    @PutMapping
    fun updateTopic(@RequestBody @Valid request: UpdateTopicRequest) {
        service.update(request)
    }

    @DeleteMapping("/{id}")
    fun deleteTopic(@PathVariable id: Long) {
        service.delete(id)
    }
}