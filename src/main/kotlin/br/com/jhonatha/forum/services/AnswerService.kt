package br.com.jhonatha.forum.services

import br.com.jhonatha.forum.dto.NewAnswerRequest
import br.com.jhonatha.forum.dto.UpdateAnswerRequest
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

    fun create(id: Long, request: NewAnswerRequest): Answer {
        val answer = Answer(
            id = answers.size.toLong() + 1,
            message = request.message,
            author = userService.findById(request.authorId),
            topic = topicService.findById(id),
        )

        answers = answers.plus(answer)

        return answer
    }

    fun update(request: UpdateAnswerRequest): Answer {
        val answer = answers.first { it.id == request.id}
        val updatedAnswer = answer.copy(message = request.message)

        answers = answers.minus(answer).plus(updatedAnswer)

        return updatedAnswer
    }

    fun delete(id: Long) {
        val answer = answers.first { it.id == id }
        answers = answers.minus(answer)
    }

}
