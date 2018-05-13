package com.u1fukui.bbsapi.repository

import com.u1fukui.bbsapi.entity.Category
import org.springframework.data.jpa.repository.JpaRepository

interface CategoryRepository : JpaRepository<Category, Long>