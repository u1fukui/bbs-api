package com.u1fukui.bbsapi.controller

import com.u1fukui.bbsapi.entity.Category
import com.u1fukui.bbsapi.service.CategoryService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CategoryController(
    private val categoryService: CategoryService
) {
    @GetMapping("/categories")
    fun getCategoryList(): ResponseEntity<List<Category>> {
        val categoryList = categoryService.findActiveCategories()
        return ResponseEntity.ok(categoryList)
    }
}