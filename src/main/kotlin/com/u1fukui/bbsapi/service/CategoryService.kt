package com.u1fukui.bbsapi.service

import com.u1fukui.bbsapi.entity.Category

interface CategoryService {
    fun findById(categoryId: Long): Category?
    fun findActiveCategories(): List<Category>
}