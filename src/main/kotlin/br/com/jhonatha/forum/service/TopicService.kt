package br.com.jhonatha.forum.service

import br.com.jhonatha.forum.dto.NewTopicRequest
import br.com.jhonatha.forum.dto.TopicResponse
import br.com.jhonatha.forum.models.Topic
import org.springframework.stereotype.Service

@Service
class TopicService(
    private var topics: List<Topic> = ArrayList(),
    private val courseService: CourseService,
    private val userService: UserService
) {

    fun list(): List<TopicResponse> {
        return this.topics.map { 
            TopicResponse(
                id = it.id ?: 0,
                title = it.title,
                message = it.message,
                status = it.status,
                createdAt = it.createdAt,
            )
        }
    }

    fun findById(id: Long): TopicResponse {
        val topic = topics.first { it.id == id }
        
        return TopicResponse(
            id = topic.id ?: 0,
            title = topic.title,
            message = topic.message,
            status = topic.status,
            createdAt = topic.createdAt,
        )
    }

    fun create(dto: NewTopicRequest) {
        topics = topics.plus(Topic(
            id = topics.size.toLong() + 1,
            title = dto.title,
            message = dto.message,
            course = courseService.findById(dto.courseId),
            author = userService.findById(dto.authorId),
        ))
    }
}