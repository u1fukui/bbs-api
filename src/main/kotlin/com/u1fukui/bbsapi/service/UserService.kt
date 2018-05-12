package com.u1fukui.bbsapi.service

import com.u1fukui.bbsapi.entity.User

interface UserService {
    fun register(user: User)
    fun find(userId: Long): User? //TODO: Use token
}