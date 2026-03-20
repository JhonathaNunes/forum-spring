package br.com.jhonatha.forum.services

import br.com.jhonatha.forum.dto.NewTopicRequest
import br.com.jhonatha.forum.dto.TopicResponse
import br.com.jhonatha.forum.dto.toTopicResponse
import br.com.jhonatha.forum.mappers.TopicRequestMapper
import br.com.jhonatha.forum.models.Topic
import org.springframework.stereotype.Service

@Service
class TopicService(
    private var topics: List<Topic> = ArrayList(),
    private val topicRequestMapper: TopicRequestMapper
) {

    fun list(): List<TopicResponse> {
        return this.topics.map {
            it.toTopicResponse()
        }
    }

    fun findById(id: Long): TopicResponse {
        return topics.first { it.id == id }.toTopicResponse()
    }

    fun create(request: NewTopicRequest) {
        val topic = topicRequestMapper.map(request)
        topic.id = topics.size.toLong() + 1

        topics = topics.plus(topic)
    }
}