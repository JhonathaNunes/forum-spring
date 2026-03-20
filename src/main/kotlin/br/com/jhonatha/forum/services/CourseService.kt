package br.com.jhonatha.forum.services

import br.com.jhonatha.forum.models.Course
import org.springframework.stereotype.Service

@Service
class CourseService(private var courses: List<Course>) {

    init {
        this.courses = Array(3) { i ->
            val id = i.toLong() + 1

            Course(
                id = id,
                name = "Kotlin $id",
                category = "Backend"
            )
        }.toList()
    }

    fun findById(id: Long): Course {
        return courses.first { it.id == id }
    }

}
