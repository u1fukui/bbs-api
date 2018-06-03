package com.u1fukui.bbsapi.controller

import com.u1fukui.bbsapi.entity.BbsThread
import com.u1fukui.bbsapi.entity.Category
import com.u1fukui.bbsapi.request.ThreadRegistrationRequest
import com.u1fukui.bbsapi.service.ThreadService
import com.u1fukui.bbsapi.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class ThreadController(
    private val userService: UserService,
    private val threadService: ThreadService
) {
    @PostMapping("/thread/register")
    fun registerThread(@RequestBody request: ThreadRegistrationRequest): ResponseEntity<String> {
        val category = Category(id = request.categoryId)
        val user = userService.find(request.authorId)
                ?: return ResponseEntity.badRequest().build()

        val thread = BbsThread(request, category, user)
        threadService.register(thread)
        return ResponseEntity.ok("success")
    }

    @GetMapping("/threads")
    fun getThreadList(
        @RequestParam(value = "category") categoryId: Long,
        @RequestParam(value = "lastId", defaultValue = "0") lastId: Long
    ): ResponseEntity<List<BbsThread>> {
        val list = threadService.findByCategoryId(categoryId, lastId)
        return ResponseEntity.ok(list)
    }
}