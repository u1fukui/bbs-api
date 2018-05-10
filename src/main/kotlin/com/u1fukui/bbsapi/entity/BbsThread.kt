package com.u1fukui.bbsapi.entity

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
@Table(name = "thread")
data class BbsThread(
    @Column(name = "title", nullable = false)
    var title: String,
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
    @Column(name = "thread_id", nullable = false)
    var id: Long = 0
) : Serializable