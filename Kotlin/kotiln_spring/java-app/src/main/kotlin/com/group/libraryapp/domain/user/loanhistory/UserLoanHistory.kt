package com.group.libraryapp.domain.user.loanhistory

import com.group.libraryapp.domain.user.User
import javax.persistence.*

/**
 * Created by Yohan lee
 * Created on 2022/10/21.
 **/

@Entity
class UserLoanHistory(

    @ManyToOne
    val user : User,

    val bookName : String,

    var isReturn : Boolean,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
) {


    fun doReturn() {
        this.isReturn = true;
    }
}