package com.u1fukui.bbsapi.repository

import com.u1fukui.bbsapi.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>