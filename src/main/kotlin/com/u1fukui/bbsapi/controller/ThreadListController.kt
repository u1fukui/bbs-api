package com.u1fukui.bbsapi.controller

import com.u1fukui.bbsapi.entity.BbsThread
import com.u1fukui.bbsapi.entity.User
import com.u1fukui.bbsapi.request.ThreadRegistrationRequest
import com.u1fukui.bbsapi.service.ThreadService
import com.u1fukui.bbsapi.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
class ThreadListController(
    private val userService: UserService,
    private val threadService: ThreadService
) {
    @PostMapping("/thread/register")
    fun registerThread(@RequestBody request: ThreadRegistrationRequest): ResponseEntity<String> {
        val user = userService.find(request.authorId)
                ?: return ResponseEntity.badRequest().build()

        val thread = BbsThread(request, user)
        threadService.register(thread)
        return ResponseEntity.ok("success")
    }

    @GetMapping("/threads")
    fun threadList(
        @RequestParam(value = "category") categoryId: Int,
        @RequestParam(value = "lastId", defaultValue = "0") lastId: Int
    ): List<BbsThread> {
        return createDebugThreadList(categoryId, lastId)
    }

    private fun createDebugThreadList(
        categoryId: Int,
        lastId: Int
    ): List<BbsThread> {
        return ((lastId + 1)..(lastId + 20)).map {
            BbsThread(
                "カテゴリスレッド$it",
                "本文",
                User("作者$it", id = it.toLong()),
                0,
                LocalDateTime.now(),
                LocalDateTime.now(),
                it.toLong()
            )
        }
    }
}