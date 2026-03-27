package br.com.jhonatha.forum.repositories

import br.com.jhonatha.forum.models.Answer
import org.springframework.data.jpa.repository.JpaRepository

interface AnswerRepository: JpaRepository<Answer, Long>