package com.u1fukui.bbsapi.request

import java.io.Serializable

data class ThreadRegistrationRequest(
    var title: String = "",
    var description: String = "",
    var categoryId: Long = 0,
    var authorId: Long = 0
): Serializable