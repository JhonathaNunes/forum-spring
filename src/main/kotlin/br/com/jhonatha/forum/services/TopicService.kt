package br.com.jhonatha.forum.services

import br.com.jhonatha.forum.dto.NewTopicRequest
import br.com.jhonatha.forum.dto.UpdateTopicRequest
import br.com.jhonatha.forum.exceptions.NotFoundException
import br.com.jhonatha.forum.mappers.TopicRequestMapper
import br.com.jhonatha.forum.models.Topic
import br.com.jhonatha.forum.repositories.TopicRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class TopicService(
    private val repository: TopicRepository,
    private val topicRequestMapper: TopicRequestMapper,
    private val notFoundMessage: String = "Topic with id %d not found"
) {

    fun list(courseName: String?, pagination: Pageable): Page<Topic> {
        return courseName?.let {
            repository.findByCourseName(courseName, pagination)
        } ?: repository.findAll(pagination)
    }

    fun findById(id: Long): Topic {
        return repository.findById(id)
            .orElseThrow { NotFoundException(notFoundMessage.format(id)) }
    }

    fun create(request: NewTopicRequest): Topic {
        val topic = topicRequestMapper.map(request)
        return repository.save(topic)
    }

    fun update(request: UpdateTopicRequest): Topic {
        val topic = repository.findById(request.id)
            .orElseThrow { NotFoundException("Topic with id ${request.id} not found") }

        topic.title = request.title
        topic.message = request.message

        return topic
    }

    fun delete(id: Long) {
        repository.deleteById(id)
    }
}