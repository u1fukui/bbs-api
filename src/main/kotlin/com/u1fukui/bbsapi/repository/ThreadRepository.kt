package com.u1fukui.bbsapi.repository

import com.u1fukui.bbsapi.entity.BbsThread
import org.springframework.data.jpa.repository.JpaRepository

interface ThreadRepository : JpaRepository<BbsThread, Long>