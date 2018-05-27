package com.u1fukui.bbsapi.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import com.u1fukui.bbsapi.request.UserRegistrationRequest
import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long = 0,
    @Column(name = "name", nullable = false)
    var name: String,
    @Column(name = "created_at", nullable = false)
    @JsonIgnore
    var createdAt: LocalDateTime = LocalDateTime.now(),
    @Column(name = "updated_at", nullable = false)
    @JsonIgnore
    var updatedAt: LocalDateTime = LocalDateTime.now()
) : Serializable {
    constructor(request: UserRegistrationRequest) : this(name = request.name)
}