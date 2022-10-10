package com.study.jpa.repository;

import com.study.jpa.entity.Locker;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Yohan lee
 * Created on 2021-01-28.
 **/
public interface LockerRepository extends JpaRepository<Locker, Long> {
}
