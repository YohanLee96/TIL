package com.group.libraryapp.controller.user

import com.group.libraryapp.dto.user.request.UserCreateRequest
import com.group.libraryapp.dto.user.request.UserUpdateRequest
import com.group.libraryapp.dto.user.response.UserResponse
import com.group.libraryapp.service.user.UserService
import org.springframework.web.bind.annotation.*

/**
 * Created by Yohan lee
 * Created on 2022/10/22.
 **/
@RestController
class UserController(
    private val userService: UserService,
) {

    @PostMapping("/user")
    fun saveUser(@RequestBody request: UserCreateRequest) {
        userService.saveUser(request)
    }

    @GetMapping("/user")
    fun getUsers() : List<UserResponse> = userService.getUsers() //이런 형식또한 가능.

    @PutMapping("/user")
    fun updateUserName(@RequestBody request : UserUpdateRequest) {
        userService.updateUserName(request)
    }


    @DeleteMapping("/user")
    fun deleteUser(@RequestParam name : String) {
        userService.deleteUser(name)
    }
}