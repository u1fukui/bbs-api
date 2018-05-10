package com.u1fukui.bbsapi.controller

import com.u1fukui.bbsapi.entity.BbsThread
import com.u1fukui.bbsapi.entity.User
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
class ThreadListController {
    @RequestMapping("/threads", method = [(RequestMethod.GET)])
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
                User("作者$it", id = it.toLong()),
                0,
                LocalDateTime.now(),
                LocalDateTime.now(),
                it.toLong()
            )
        }
    }
}