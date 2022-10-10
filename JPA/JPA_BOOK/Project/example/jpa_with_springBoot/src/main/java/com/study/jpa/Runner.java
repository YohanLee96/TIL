package com.study.jpa;

import com.study.jpa.entity.Locker;
import com.study.jpa.entity.Member;
import com.study.jpa.entity.Team;
import com.study.jpa.repository.LockerRepository;
import com.study.jpa.repository.MemberRepository;
import com.study.jpa.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Created by Yohan lee
 * Created on 2021-01-28.
 **/

@Component
@RequiredArgsConstructor
public class Runner implements ApplicationRunner {

    private final MemberRepository memberRepository;
    private final TeamRepository teamRepository;
    private final LockerRepository lockerRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        Team team = new Team("팀1");
        Team savedTeam = teamRepository.save(team);

        Locker locker = new Locker("락커1");
        Locker savedLocker = lockerRepository.save(locker);

        Member member = new Member();
        member.setUserName("이요한");
        member.setTeam(savedTeam);
        member.setLocker(savedLocker);
        Member savedMember = memberRepository.save(member);

        System.out.println(savedMember.toString());
    }
}
