package com.u1fukui.bbsapi.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "categories")
data class Category(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long = 0,
    @Column(name = "name", nullable = false)
    var name: String = "",
    @Column(name = "order_num", nullable = false)
    @JsonIgnore
    var order: Int = 0,
    @Column(name = "disabled", nullable = false)
    @JsonIgnore
    var disabled: Boolean = false,
    @Column(name = "created_at", nullable = false)
    @JsonIgnore
    var createdAt: LocalDateTime = LocalDateTime.now(),
    @Column(name = "updated_at", nullable = false)
    @JsonIgnore
    var updatedAt: LocalDateTime = LocalDateTime.now(),
    @OneToMany(mappedBy = "category")
    @JsonIgnoreProperties("category")
    var threads: List<BbsThread> = emptyList()
) : Serializable {

    constructor(categoryId: Long) : this(id = categoryId)
}