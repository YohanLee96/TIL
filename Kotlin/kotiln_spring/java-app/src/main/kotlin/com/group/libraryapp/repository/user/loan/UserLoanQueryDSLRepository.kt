package com.group.libraryapp.repository.user.loan

import com.group.libraryapp.domain.user.loanhistory.QUserLoanHistory.userLoanHistory
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistory
import com.group.libraryapp.domain.user.loanhistory.UserLoanStatus
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Component

/**
 * Created by Yohan lee
 * Created on 2022/10/23.
 **/

@Component
class UserLoanQueryDSLRepository(
    private val queryFactory : JPAQueryFactory,
) {
    fun find(bookName : String, status : UserLoanStatus? =null) : UserLoanHistory? {
        return queryFactory
            .select(userLoanHistory)
            .from(userLoanHistory)
            .where(
                userLoanHistory.bookName.eq(bookName),
                //status 파라미터가 null이 아닌경우에만 실행.
                status?.let { userLoanHistory.status.eq(status) }
            )
            .limit(1)
            .fetchOne()
    }

    fun count(status : UserLoanStatus) : Long {
        return queryFactory
            .select(userLoanHistory.count())
            .from(userLoanHistory)
            .where(userLoanHistory.status.eq(status))
            .fetchOne() ?: 0L // 엘비스 연산자를 통해 삼항연산자를 안쓰고 간단하게 바로 null분기 가능.

    }
}