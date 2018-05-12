package com.u1fukui.bbsapi.service

import com.u1fukui.bbsapi.entity.BbsThread

interface ThreadService {
    fun register(thread: BbsThread)
}