package com.u1fukui.bbsapi.controller

import com.u1fukui.bbsapi.model.BbsThread
import com.u1fukui.bbsapi.model.User
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import java.util.Date

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
                it.toLong(),
                "カテゴリスレッド$it",
                User(it.toLong(), "作者$it"),
                0,
                Date(),
                Date()
            )
        }
    }
}