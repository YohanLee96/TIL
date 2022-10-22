package com.group.libraryapp.repository.book

import com.group.libraryapp.domain.book.QBook.book
import com.group.libraryapp.dto.book.response.BookStatResponse
import com.group.libraryapp.dto.book.response.QBookStatResponse
import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Component

/**
 * Created by Yohan lee
 * Created on 2022/10/23.
 **/

@Component
class BookQueryDslRepository(
    private val queryFactory: JPAQueryFactory,
) {

    fun getStats(): List<BookStatResponse> {
        return queryFactory
            .select(QBookStatResponse(book.type, book.count()))
            .from(book)
            .groupBy(book.type)
            .fetch()
    }
}