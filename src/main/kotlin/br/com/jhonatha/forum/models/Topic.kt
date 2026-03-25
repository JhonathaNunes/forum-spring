package br.com.jhonatha.forum.models

import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
data class Topic (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var title: String,
    var message: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    @UpdateTimestamp
    val updatedAt: LocalDateTime = LocalDateTime.now(),
    @ManyToOne
    val course: Course,
    @ManyToOne
    val author: User,
    @Enumerated(EnumType.STRING)
    val status: TopicStatus = TopicStatus.NOT_ANSWERED,
    @OneToMany(mappedBy = "topic")
    val answers: MutableList<Answer> = ArrayList(),
)