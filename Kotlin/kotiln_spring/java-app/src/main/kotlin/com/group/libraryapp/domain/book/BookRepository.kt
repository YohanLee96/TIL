package com.group.libraryapp.domain.book

import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

/**
 * Created by Yohan lee
 * Created on 2022/10/22.
 **/
interface BookRepository : JpaRepository<Book, Long> {

    fun findByName(bookName : String) : Book?
}