package br.com.jhonatha.forum.services

import br.com.jhonatha.forum.exceptions.NotFoundException
import br.com.jhonatha.forum.models.User
import br.com.jhonatha.forum.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val repository: UserRepository) {

    fun findById(id: Long): User {
        return repository.findById(id).orElseThrow { NotFoundException("User with id $id not found") }
    }

}
