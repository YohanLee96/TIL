package com.group.libraryapp.domain.user

import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

/**
 * Created by Yohan lee
 * Created on 2022/10/22.
 **/
interface UserRepository : JpaRepository<User, Long> {
    
    fun findByName(name: String) : User?
}