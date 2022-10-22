package com.group.libraryapp.domain.book

import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by Yohan lee
 * Created on 2022/10/22.
 **/
interface BookRepository : JpaRepository<Book, Long> {

    fun findByName(bookName : String) : Book?
}