package com.u1fukui.bbsapi.model

import java.util.Date

data class BbsThread(
        val id: Long,
        val title: String,
        val author: User,
        val commentCount: Int,
        val createdAt: Date,
        val updatedAt: Date
)