package com.study.datajpa.entity;

import jakarta.persistence.EntityManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class MemberTest {
    @Autowired
    private EntityManager entityManager;

    @Test
    public void testEntity(){
        //given
        Team teamA = new Team("팀1");
        Team teamB = new Team("팀2");
        entityManager.persist(teamA);
        entityManager.persist(teamB);
        Member member1 = new Member("김기범1", 29, teamA);
        Member member2 = new Member("김기범2", 29, teamA);
        Member member3 = new Member("김기범3", 29, teamB);
        Member member4 = new Member("김기범4", 29, teamB);
        entityManager.persist(member1);
        entityManager.persist(member2);
        entityManager.persist(member3);
        entityManager.persist(member4);

        //when
        entityManager.flush(); // 영속성 컨텍스트에 있는 데이터를 전부 DB로 전송
        entityManager.clear(); // 영속성 컨텍스트에 있는 데이터 전부 clear

        //then
    }
}