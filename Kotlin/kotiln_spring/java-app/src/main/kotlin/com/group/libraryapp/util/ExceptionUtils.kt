package com.group.libraryapp.util

import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.findByIdOrNull
import java.lang.IllegalArgumentException

/**
 * Created by Yohan lee
 * Created on 2022/10/22.
 **/

fun fail() : Nothing {
    throw IllegalArgumentException()
}

fun <T, ID> CrudRepository<T, ID>.findByIdOrThrow(id : ID) : T {
    return this.findByIdOrNull(id) ?: fail()
}