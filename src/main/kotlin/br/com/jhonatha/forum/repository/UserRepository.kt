package br.com.jhonatha.forum.repository

import br.com.jhonatha.forum.models.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long>