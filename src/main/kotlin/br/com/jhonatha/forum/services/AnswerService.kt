package br.com.jhonatha.forum.services

import br.com.jhonatha.forum.dto.NewAnswerRequest
import br.com.jhonatha.forum.models.Answer
import org.springframework.stereotype.Service

@Service
class AnswerService(
    private var answers: List<Answer>,
    private val userService: UserService,
    private val topicService: TopicService
) {

    fun getAnswersFromTopic(topicId: Long): List<Answer> {
        return answers.filter {
            it.topic.id == topicId
        }
    }

    fun create(id: Long, request: NewAnswerRequest) {
        answers = answers.plus(Answer(
            id = answers.size.toLong() + 1,
            message = request.message,
            author = userService.findById(request.authorId),
            topic = topicService.findById(id),
        ))
    }

}
