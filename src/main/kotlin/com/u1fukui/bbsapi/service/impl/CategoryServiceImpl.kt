package com.u1fukui.bbsapi.service.impl

import com.u1fukui.bbsapi.entity.Category
import com.u1fukui.bbsapi.repository.CategoryRepository
import com.u1fukui.bbsapi.service.CategoryService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CategoryServiceImpl(
    private val repository: CategoryRepository
) : CategoryService {
    @Transactional(readOnly = true)
    override fun findById(categoryId: Long): Category? {
        return repository.findById(categoryId).orElseGet(null)
    }
}