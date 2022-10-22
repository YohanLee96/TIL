package com.group.libraryapp.domain.user

/**
 * Created by Yohan lee
 * Created on 2022/10/23.
 **/
interface UserRepositoryCustom {

    fun findAllWithHistories() : List<User>
}