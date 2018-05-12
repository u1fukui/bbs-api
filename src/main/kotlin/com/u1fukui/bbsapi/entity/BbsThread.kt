package com.u1fukui.bbsapi.entity

import com.u1fukui.bbsapi.request.ThreadRegistrationRequest
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
data class BbsThread(
    @Column(name = "title", nullable = false)
    var title: String,
    @Column(name = "description", nullable = false)
    var description: String,
    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    var author: User,
    @Column(name = "comment_count", nullable = false)
    var commentCount: Int = 0,
    @Column(name = "created_at", nullable = false)
    var createdAt: LocalDateTime = LocalDateTime.now(),
    @Column(name = "updated_at", nullable = false)
    var updatedAt: LocalDateTime = LocalDateTime.now(),
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long = 0
) : Serializable {
    constructor(request: ThreadRegistrationRequest, author: User) : this(
        request.title,
        request.description,
        author
    )
}