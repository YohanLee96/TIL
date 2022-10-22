package com.group.libraryapp.controller.user

import com.group.libraryapp.dto.user.request.UserCreateRequest
import com.group.libraryapp.dto.user.request.UserUpdateRequest
import com.group.libraryapp.dto.user.response.UserLoanHistoryResponse
import com.group.libraryapp.dto.user.response.UserResponse
import com.group.libraryapp.service.user.UserService
import org.springframework.web.bind.annotation.*

/**
 * Created by Yohan lee
 * Created on 2022/10/22.
 **/
@RestController
@RequestMapping("/user")
class UserController(
    private val userService: UserService,
) {

    @PostMapping("")
    fun saveUser(@RequestBody request: UserCreateRequest) {
        userService.saveUser(request)
    }

    @GetMapping("")
    fun getUsers() : List<UserResponse> = userService.getUsers() //이런 형식또한 가능.

    @PutMapping("")
    fun updateUserName(@RequestBody request : UserUpdateRequest) {
        userService.updateUserName(request)
    }


    @DeleteMapping("/user")
    fun deleteUser(@RequestParam name : String) {
        userService.deleteUser(name)
    }

    @GetMapping("/loan")
    fun getUserLoanHistories() : List<UserLoanHistoryResponse> {
        return userService.getUserLoanHistories();
    }
}