package br.com.jhonatha.forum.controllers

import br.com.jhonatha.forum.models.Course
import br.com.jhonatha.forum.models.Topic
import br.com.jhonatha.forum.models.User
import br.com.jhonatha.forum.service.TopicService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/topics")
class TopicController(private val service: TopicService) {

    @GetMapping
    fun list(): List<Topic> {
        return service.list()
    }
}