package com.study.jpa.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by Yohan lee
 * Created on 2021-01-28.
 **/

@Getter
@Setter
@Entity
@NoArgsConstructor
@ToString
public class Member {

    @Id
    @GeneratedValue
    private Long id;

    private String userName;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @OneToOne
    @JoinColumn(name = "locker_id")
    private Locker locker;


}
