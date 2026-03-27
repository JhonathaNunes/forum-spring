package br.com.jhonatha.forum.repositories

import br.com.jhonatha.forum.dto.TopicsByCategoryResponse
import br.com.jhonatha.forum.models.Topic
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TopicRepository: JpaRepository<Topic, Long> {
    fun findByCourseName(courseName: String, pagination: Pageable): Page<Topic>

    @Query("SELECT " +
            "new br.com.jhonatha.forum.dto.TopicsByCategoryResponse (course.category, count(t)) " +
            "FROM Topic t JOIN t.course course GROUP BY course.category"
    )
    fun topicsByCategory(): List<TopicsByCategoryResponse>

    @Query("SELECT t FROM Topic t WHERE t.answers is empty")
    fun listNotAnsweredTopics(): List<Topic>
}