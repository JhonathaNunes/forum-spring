package br.com.jhonatha.forum.services

import br.com.jhonatha.forum.dto.NewAnswerRequest
import br.com.jhonatha.forum.dto.UpdateAnswerRequest
import br.com.jhonatha.forum.exceptions.NotFoundException
import br.com.jhonatha.forum.models.Answer
import br.com.jhonatha.forum.repositories.AnswerRepository
import org.springframework.stereotype.Service

@Service
class AnswerService(
    private val repository: AnswerRepository,
    private val userService: UserService,
    private val topicService: TopicService,
    private val notFoundErrorMessage: String = "Answer with id %d not found",
) {

    fun getAnswersFromTopic(topicId: Long): List<Answer> {
        return repository.findByTopicId(topicId)
    }

    fun create(id: Long, request: NewAnswerRequest): Answer {
        val answer = Answer(
            message = request.message,
            author = userService.findById(request.authorId),
            topic = topicService.findById(id),
        )

        return repository.save(answer)
    }

    fun getAnswer(
        id: Long,
    ): Answer {
        return repository.findById(id)
            .orElseThrow { NotFoundException(notFoundErrorMessage.format(id)) }
    }

    fun update(request: UpdateAnswerRequest): Answer {
        val answer = getAnswer(request.id)
        answer.message = request.message

        return answer
    }

    fun delete(id: Long) = repository.deleteById(id)
}
