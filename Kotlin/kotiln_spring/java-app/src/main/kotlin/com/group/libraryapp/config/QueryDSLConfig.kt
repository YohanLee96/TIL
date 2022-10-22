package com.group.libraryapp.config

import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.persistence.EntityManager

/**
 * Created by Yohan lee
 * Created on 2022/10/23.
 **/

@Configuration
class QueryDSLConfig(
    private val em : EntityManager,
) {

    @Bean
    fun queryDsl() : JPAQueryFactory {
        return JPAQueryFactory(em)
    }
}