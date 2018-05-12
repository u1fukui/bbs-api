package com.u1fukui.bbsapi.service.impl

import com.u1fukui.bbsapi.entity.BbsThread
import com.u1fukui.bbsapi.repository.ThreadRepository
import com.u1fukui.bbsapi.service.ThreadService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ThreadServiceImpl(
    private val repository: ThreadRepository
) : ThreadService {
    @Transactional(timeout = 10)
    override fun register(thread: BbsThread) {
        repository.save(thread)
    }
}