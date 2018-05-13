package com.u1fukui.bbsapi.entity

import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "categories")
data class Category(
    @Column(name = "name", nullable = false)
    var name: String = "",
    @Column(name = "order_num", nullable = false)
    var order: Int = 0,
    @Column(name = "disabled", nullable = false)
    var isDisabled: Boolean = false,
    @Column(name = "created_at", nullable = false)
    var createdAt: LocalDateTime = LocalDateTime.now(),
    @Column(name = "updated_at", nullable = false)
    var updatedAt: LocalDateTime = LocalDateTime.now(),
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long = 0
) : Serializable {
    constructor(categoryId: Long) : this(id = categoryId)
}