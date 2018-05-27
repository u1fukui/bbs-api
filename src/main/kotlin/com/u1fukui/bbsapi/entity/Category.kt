package com.u1fukui.bbsapi.entity

import com.fasterxml.jackson.annotation.JsonIgnore
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
    var id: Long? = null,
    @Column(name = "name", nullable = false)
    var name: String? = null,
    @Column(name = "order_num", nullable = false)
    @JsonIgnore
    var order: Int? = null,
    @Column(name = "disabled", nullable = false)
    @JsonIgnore
    var disabled: Boolean? = null,
    @Column(name = "created_at", nullable = false)
    @JsonIgnore
    var createdAt: LocalDateTime? = null,
    @Column(name = "updated_at", nullable = false)
    @JsonIgnore
    var updatedAt: LocalDateTime? = null,
    @OneToMany(mappedBy = "category")
    @JsonIgnore
    var threads: List<BbsThread> = emptyList()
) : Serializable