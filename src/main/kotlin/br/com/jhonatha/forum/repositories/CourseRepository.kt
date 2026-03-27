package br.com.jhonatha.forum.repositories

import br.com.jhonatha.forum.models.Course
import org.springframework.data.jpa.repository.JpaRepository

interface CourseRepository: JpaRepository<Course, Long>