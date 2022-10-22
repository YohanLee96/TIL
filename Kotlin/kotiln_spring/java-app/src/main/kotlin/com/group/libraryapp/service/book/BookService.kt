package com.group.libraryapp.service.book

import com.group.libraryapp.domain.book.Book
import com.group.libraryapp.domain.book.BookRepository
import com.group.libraryapp.domain.user.UserRepository
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistoryRepository
import com.group.libraryapp.domain.user.loanhistory.UserLoanStatus
import com.group.libraryapp.dto.book.request.BookLoanRequest
import com.group.libraryapp.dto.book.request.BookRequest
import com.group.libraryapp.dto.book.request.BookReturnRequest
import com.group.libraryapp.dto.book.response.BookStatResponse
import com.group.libraryapp.repository.book.BookQueryDslRepository
import com.group.libraryapp.repository.user.loan.UserLoanQueryDSLRepository
import com.group.libraryapp.util.fail
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * Created by Yohan lee
 * Created on 2022/10/22.
 **/

@Service
class BookService(
    private val bookRepository: BookRepository,
    private val bookQueryDslRepository: BookQueryDslRepository,
    private val userRepository: UserRepository,
    private val userLoanQueryDSLRepository: UserLoanQueryDSLRepository,
) {

    @Transactional
    fun saveBook(request: BookRequest) {
        val book = Book(request.name, request.type)
        bookRepository.save(book)
    }

    @Transactional
    fun loanBook(request : BookLoanRequest) {
        val book = bookRepository.findByName(request.bookName) ?: fail()
        if(userLoanQueryDSLRepository.find(request.bookName, UserLoanStatus.LOANED) != null) {
            throw IllegalArgumentException("진작 대출되어 있는 책입니다")
        }

        val user = userRepository.findByName(request.userName) ?: fail()
        user.loanBook(book)
    }

    @Transactional
    fun returnBook(request : BookReturnRequest) {
        val user = userRepository.findByName(request.userName) ?: fail()
        user.returnBook(request.bookName)
    }


    @Transactional(readOnly = true)
    fun countLoanedBook(): Int {
        return userLoanQueryDSLRepository.count(UserLoanStatus.LOANED).toInt()
    }

    @Transactional(readOnly = true)
    fun getBookStat(): List<BookStatResponse> {
        return bookQueryDslRepository.getStats()
    }
}