package com.study.datajpa.repository;

import com.study.datajpa.entity.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberJpaRepositoryTest {

    @Autowired
    private MemberJpaRepository memberJpaRepository;

    /*@Test
    void save() {
        //given
        Member member1 = new Member("김기범", 29, );
        //when
        Long memberId = memberJpaRepository.save(member1);
        //then
        Assertions.assertThat(memberJpaRepository.findOne(memberId).getId()).isEqualTo(member1.getId());
    }*/

    @Test
    void findOne() {
    }
}