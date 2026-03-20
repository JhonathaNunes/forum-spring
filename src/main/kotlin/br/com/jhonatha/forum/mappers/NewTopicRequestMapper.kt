package br.com.jhonatha.forum.mappers

import br.com.jhonatha.forum.dto.NewTopicRequest
import br.com.jhonatha.forum.models.Topic
import br.com.jhonatha.forum.services.CourseService
import br.com.jhonatha.forum.services.UserService
import org.springframework.stereotype.Component

@Component
class TopicRequestMapper(
    private val courseService: CourseService,
    private val userService: UserService,
): Mapper<NewTopicRequest, Topic> {

    override fun map(t: NewTopicRequest): Topic {
        return Topic(
            title = t.title,
            message = t.message,
            course = courseService.findById(t.courseId),
            author = userService.findById(t.authorId),
        )
    }

}
