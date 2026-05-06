package br.com.jhonatha.forum.services

import br.com.jhonatha.forum.exceptions.NotFoundException
import br.com.jhonatha.forum.models.User
import br.com.jhonatha.forum.models.UserDetail
import br.com.jhonatha.forum.repositories.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserService(private val repository: UserRepository) : UserDetailsService {

    fun findById(id: Long): User {
        return repository.findById(id).orElseThrow { NotFoundException("User with id $id not found") }
    }

    override fun loadUserByUsername(username: String): UserDetails {
        val user = repository.findByEmail(username)
            ?: throw NotFoundException("User with username: $username not found")

        return UserDetail(user)
    }

}
