package br.com.jhonatha.forum.service

import br.com.jhonatha.forum.models.User
import org.springframework.stereotype.Service

@Service
class UserService(private var users: List<User>) {
    init {
        this.users = Array(3) { i ->
            val id = i.toLong() + 1

            User(
                id = id,
                name = "John Doe $id",
                email = "jhon.doe+$id@test.com",
            )
        }.toList()
    }

    fun findById(id: Long): User {
        return users.first { it.id == id }
    }

}
