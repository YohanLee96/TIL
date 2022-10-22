package com.group.libraryapp.dto.book.response

import com.group.libraryapp.domain.book.BookType
import com.querydsl.core.annotations.QueryProjection

/**
 * Created by Yohan lee
 * Created on 2022/10/22.
 **/
data class BookStatResponse @QueryProjection constructor(
    val type : BookType,
    val count : Long
) {
}
