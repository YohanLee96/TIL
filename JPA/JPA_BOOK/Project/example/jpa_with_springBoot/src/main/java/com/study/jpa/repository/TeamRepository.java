package com.study.jpa.repository;

import com.study.jpa.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Yohan lee
 * Created on 2021-01-28.
 **/
public interface TeamRepository extends JpaRepository<Team, Long> {
}
