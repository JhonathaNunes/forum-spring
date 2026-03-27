package br.com.jhonatha.forum.controllers

import br.com.jhonatha.forum.dto.NewTopicRequest
import br.com.jhonatha.forum.dto.TopicResponse
import br.com.jhonatha.forum.dto.TopicsByCategoryResponse
import br.com.jhonatha.forum.dto.UpdateTopicRequest
import br.com.jhonatha.forum.dto.toTopicResponse
import br.com.jhonatha.forum.models.Topic
import br.com.jhonatha.forum.services.TopicService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder


@RestController
@RequestMapping("/topics")
class TopicController(private val service: TopicService) {

    @GetMapping
    @Cacheable("topics")
    fun getAllTopics(
        @RequestParam courseName: String?,
        @PageableDefault(sort = ["createdAt"], direction = Sort.Direction.DESC) pagination: Pageable
    ): Page<TopicResponse> {
        return service.list(courseName, pagination).map {
            it.toTopicResponse()
        }
    }

    @GetMapping("/{id}")
    fun getTopicById(@PathVariable id: Long): TopicResponse {
        return service.findById(id).toTopicResponse()
    }

    @PostMapping
    @Transactional
    @CacheEvict(value = ["topics"], allEntries = true)
    fun createTopic(
        @RequestBody @Valid request: NewTopicRequest,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<TopicResponse> {
        val topicResponse = service.create(request).toTopicResponse()
        val uri = uriBuilder.path("/topics/${topicResponse.id}").build().toUri()

        return ResponseEntity.created(uri).body(topicResponse)
    }

    @PutMapping
    @Transactional
    @CacheEvict(value = ["topics"], allEntries = true)
    fun updateTopic(@RequestBody @Valid request: UpdateTopicRequest): ResponseEntity<TopicResponse> {
        val topicResponse = service.update(request).toTopicResponse()

        return ResponseEntity.ok(topicResponse)
    }

    @DeleteMapping("/{id}")
    @Transactional
    @CacheEvict(value = ["topics"], allEntries = true)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteTopic(@PathVariable id: Long) {
        service.delete(id)
    }

    @GetMapping("/report")
    fun topicsByCategory(): List<TopicsByCategoryResponse> {
        return service.topicsByCategory()
    }

    @GetMapping("/not_answered")
    fun listNotAnsweredTopics(): List<Topic> {
        return service.listNotAnsweredTopics()
    }
}