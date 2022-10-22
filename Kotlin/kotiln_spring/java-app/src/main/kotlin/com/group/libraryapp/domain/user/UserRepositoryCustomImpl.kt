package com.group.libraryapp.domain.user

import com.group.libraryapp.domain.user.QUser.user
import com.querydsl.jpa.impl.JPAQueryFactory

/**
 * Created by Yohan lee
 * Created on 2022/10/23.
 **/
class UserRepositoryCustomImpl(
    private val queryFactory : JPAQueryFactory,
) : UserRepositoryCustom {

    override fun findAllWithHistories() : List<User> {

        return queryFactory
            .select(user).distinct()
            .from(user)
            .leftJoin(user.userLoanHistories).fetchJoin()
            .fetch();
    }

}