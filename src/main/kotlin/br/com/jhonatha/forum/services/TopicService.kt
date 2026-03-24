package br.com.jhonatha.forum.services

import br.com.jhonatha.forum.dto.NewTopicRequest
import br.com.jhonatha.forum.dto.UpdateTopicRequest
import br.com.jhonatha.forum.exceptions.NotFoundException
import br.com.jhonatha.forum.mappers.TopicRequestMapper
import br.com.jhonatha.forum.models.Topic
import org.springframework.stereotype.Service

@Service
class TopicService(
    private var topics: List<Topic> = ArrayList(),
    private val topicRequestMapper: TopicRequestMapper,
    private val notFoundMessage: String = "Topic with id %d not found"
) {

    fun list(): List<Topic> {
        return this.topics
    }

    fun findById(id: Long): Topic {
        return topics.find { it.id == id } ?: throw NotFoundException(notFoundMessage.format(id))
    }

    fun create(request: NewTopicRequest): Topic {
        val topic = topicRequestMapper.map(request)
        topic.id = topics.size.toLong() + 1

        topics = topics.plus(topic)

        return topic
    }

    fun update(request: UpdateTopicRequest): Topic {
        val topic = this.findById(request.id)
        val updatedTopic = topic.copy(
            title = request.title,
            message = request.message,
        )

        topics = topics.minus(topic)
            .plus(updatedTopic)

        return updatedTopic
    }

    fun delete(id: Long) {
        val topic = this.findById(id)

        topics = topics.minus(topic)
    }
}