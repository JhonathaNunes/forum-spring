package br.com.jhonatha.forum.repository

import br.com.jhonatha.forum.models.Topic
import org.springframework.data.jpa.repository.JpaRepository

interface TopicRepository: JpaRepository<Topic, Long> {
    fun findByCourseName(courseName: String): List<Topic>
}