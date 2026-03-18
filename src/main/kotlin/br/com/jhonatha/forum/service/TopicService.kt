package br.com.jhonatha.forum.service

import br.com.jhonatha.forum.models.Course
import br.com.jhonatha.forum.models.Topic
import br.com.jhonatha.forum.models.User
import org.springframework.stereotype.Service

@Service
class TopicService {
    
    fun list(): List<Topic> {
        val topic = Topic(
            id = 1,
            title = "Topic 1",
            message = "Hello World!",
            course = Course(
                id = 1,
                name = "Kotlin + Spring",
                category = "BackEnd"
            ),
            author = User(
                id = 1,
                name = "Jhonatha Nunes",
                email = "jhonathasilveira@gmail.com"
            ),
        )

        return listOf(topic, topic, topic)
    }
}