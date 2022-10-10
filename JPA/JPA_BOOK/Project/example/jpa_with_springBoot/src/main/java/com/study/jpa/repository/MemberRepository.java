package com.study.jpa.repository;

import com.study.jpa.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Yohan lee
 * Created on 2021-01-28.
 **/
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
