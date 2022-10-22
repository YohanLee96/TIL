package com.group.libraryapp.domain.user

import com.group.libraryapp.domain.book.Book
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistory
import com.group.libraryapp.domain.user.loanhistory.UserLoanStatus
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany

/**
 * Created by Yohan lee
 * Created on 2022/10/21.
 **/
@Entity
class User constructor( // constructor 키워드를 생략해도되지만, 인텔리제이에서 생성자 로직만 찾고자할때 "constructor"가 있으면 생성자로직만 서치할 수 있어 편하다..
    var name : String,
    var age: Int?,

    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], orphanRemoval = true)
    val userLoanHistories : MutableList<UserLoanHistory> = mutableListOf(),

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long? = null,
) {

    init {
        if(name.isBlank()) {
            throw IllegalArgumentException("이름은 비어 있을 수 없습니다.")
        }
    }

    fun updateName(name : String) {
        this.name = name
    }

    fun loanBook(book : Book) {
        this.userLoanHistories.add(UserLoanHistory(this, book.name, UserLoanStatus.LOANED))
    }

    fun returnBook(bookName : String) {
        this.userLoanHistories
            .first { history -> history.bookName == bookName}
            .doReturn()
    }
}