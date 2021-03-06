package com.u1fukui.bbsapi.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.u1fukui.bbsapi.request.ThreadRegistrationRequest
import org.hibernate.annotations.NamedQuery
import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "threads")
@NamedQuery(name = "findByCategoryId",
    query = "SELECT t FROM BbsThread t WHERE t.category.id = :categoryId AND t.id > :lastId ORDER BY t.id DESC")
data class BbsThread(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long = 0,
    @Column(name = "title", nullable = false)
    var title: String,
    @Column(name = "description", nullable = false)
    var description: String,
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    @JsonIgnoreProperties("threads")
    var category: Category,
    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    var author: User,
    @Column(name = "comment_count", nullable = false)
    var commentCount: Int = 0,
    @Column(name = "created_at", nullable = false)
    var createdAt: LocalDateTime = LocalDateTime.now(),
    @Column(name = "updated_at", nullable = false)
    @JsonIgnore
    var updatedAt: LocalDateTime = LocalDateTime.now()
) : Serializable {
    constructor(
        request: ThreadRegistrationRequest,
        category: Category,
        author: User
    ) : this(
        title = request.title,
        description = request.description,
        category = category,
        author = author
    )
}