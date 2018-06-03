package com.u1fukui.bbsapi.service.impl

import com.u1fukui.bbsapi.entity.BbsThread
import com.u1fukui.bbsapi.repository.ThreadRepository
import com.u1fukui.bbsapi.service.ThreadService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager

@Service
class ThreadServiceImpl(
    private val repository: ThreadRepository
) : ThreadService {
    @Autowired
    lateinit var entityManager: EntityManager

    @Transactional(timeout = 10)
    override fun register(thread: BbsThread) {
        repository.save(thread)
    }

    @Transactional(timeout = 10)
    override fun findByCategoryId(categoryId: Long, lastId: Long): List<BbsThread> =
        entityManager.createNamedQuery("findByCategoryId", BbsThread::class.java)
            .setParameter("categoryId", categoryId)
            .setParameter("lastId", lastId)
            .setMaxResults(20)
            .resultList
}