package com.study.jpa.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Created by Yohan lee
 * Created on 2021-01-28.
 **/

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Locker {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToOne(mappedBy = "locker")
    private Member member;

    public Locker(String name) {
        this.name = name;
    }
}
