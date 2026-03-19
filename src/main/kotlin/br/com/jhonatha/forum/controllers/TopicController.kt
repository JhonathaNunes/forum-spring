package br.com.jhonatha.forum.controllers

import br.com.jhonatha.forum.dto.NewTopicRequest
import br.com.jhonatha.forum.dto.TopicResponse
import br.com.jhonatha.forum.service.TopicService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/topics")
class TopicController(private val service: TopicService) {

    @GetMapping
    fun getAllTopics(): List<TopicResponse> {
        return service.list()
    }

    @GetMapping("/{id}")
    fun getTopicById(@PathVariable id: Long): TopicResponse {
        return service.findById(id)
    }

    @PostMapping
    fun createTopic(@RequestBody topic: NewTopicRequest) {
        service.create(topic)
    }
}