package br.com.jhonatha.forum.services

import br.com.jhonatha.forum.exceptions.NotFoundException
import br.com.jhonatha.forum.models.Course
import br.com.jhonatha.forum.repository.CourseRepository
import org.springframework.stereotype.Service

@Service
class CourseService(private val repository: CourseRepository) {
    fun findById(id: Long): Course {
        return repository.findById(id).orElseThrow { throw NotFoundException("Course with id $id not found") }
    }

}
