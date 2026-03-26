package br.com.jhonatha.forum.repository

import br.com.jhonatha.forum.models.Topic
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface TopicRepository: JpaRepository<Topic, Long> {
    fun findByCourseName(courseName: String, pagination: Pageable): Page<Topic>
}