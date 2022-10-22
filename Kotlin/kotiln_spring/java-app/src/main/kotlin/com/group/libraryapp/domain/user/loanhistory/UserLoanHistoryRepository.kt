package com.group.libraryapp.domain.user.loanhistory

import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by Yohan lee
 * Created on 2022/10/22.
 **/
interface UserLoanHistoryRepository : JpaRepository<UserLoanHistory, Long>