package com.u1fukui.bbsapi.controller

import com.u1fukui.bbsapi.entity.User
import com.u1fukui.bbsapi.request.UserRegistrationRequest
import com.u1fukui.bbsapi.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["user"])
class UserController(
    private val service: UserService
) {
    @PostMapping("/register", consumes = ["application/json"])
    fun registerUser(@RequestBody request: UserRegistrationRequest): ResponseEntity<String> {
        val user = User(request)
        service.register(user)
        return ResponseEntity.ok("success")
    }
}