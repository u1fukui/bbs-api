package com.u1fukui.bbsapi.service.impl

import com.u1fukui.bbsapi.entity.User
import com.u1fukui.bbsapi.repository.UserRepository
import com.u1fukui.bbsapi.service.UserService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserServiceImpl(
    private val repository: UserRepository
) : UserService {
    @Transactional(timeout = 10)
    override fun register(user: User) {
        repository.save(user)
    }
}