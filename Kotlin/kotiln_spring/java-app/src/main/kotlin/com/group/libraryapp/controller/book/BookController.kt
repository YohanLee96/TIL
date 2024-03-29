package com.group.libraryapp.controller.book

import com.group.libraryapp.dto.book.request.BookLoanRequest
import com.group.libraryapp.dto.book.request.BookRequest
import com.group.libraryapp.dto.book.request.BookReturnRequest
import com.group.libraryapp.dto.book.response.BookStatResponse
import com.group.libraryapp.service.book.BookService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

/**
 * Created by Yohan lee
 * Created on 2022/10/22.
 **/

@RestController
class BookController(
    private val bookService: BookService
) {

    @PostMapping("/book")
    fun saveBook(@RequestBody request: BookRequest) {
        bookService.saveBook(request)
    }


    @PostMapping("/book/loan")
    fun loanBook(@RequestBody request: BookLoanRequest) {
        bookService.loanBook(request)
    }

    @PutMapping("/book/return")
    fun loanBook(@RequestBody request: BookReturnRequest) {
        bookService.returnBook(request)
    }

    @GetMapping("/book/loan")
    fun getBookLoan() : Int {
        return bookService.countLoanedBook()
    }

    @GetMapping("/book/stat")
    fun getBookStat() : List<BookStatResponse> {
        return bookService.getBookStat()
    }
}