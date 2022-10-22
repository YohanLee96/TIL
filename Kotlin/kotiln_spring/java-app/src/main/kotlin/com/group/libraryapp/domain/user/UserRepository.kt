package com.group.libraryapp.domain.user

import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by Yohan lee
 * Created on 2022/10/22.
 **/
interface UserRepository : JpaRepository<User, Long>, UserRepositoryCustom {
    
    fun findByName(name: String) : User?

}