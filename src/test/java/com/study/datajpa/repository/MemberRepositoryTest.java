package com.study.datajpa.repository;

import com.study.datajpa.entity.Member;
import com.study.datajpa.entity.Team;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class MemberRepositoryTest {
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private MemberJpaRepository memberJpaRepository;
    @Autowired
    private TeamRepository teamRepository;

    @Test
    public void testMember(){
        System.out.println("MemberRepository: "+memberRepository.getClass());
    }

    /*@Test
    void save() {
        //given
        Member member1 = new Member("김기범");
        //when
        Member member2 = memberRepository.save(member1);
        Optional<Member> memberOptional = memberRepository.findById(member2.getId());
        Member member3 = memberOptional.get();
        //then
        Assertions.assertThat(member3.getId()).isEqualTo(member1.getId());
    }*/

    @Test
    public void CRUD(){
        //저장
        Team teamA = new Team("팀1");
        teamRepository.save(teamA);
        Member member1 = new Member("김기범1", 29, teamA);
        Member member11 = new Member("김기범11", 29, teamA);
        Long memberId2 = memberJpaRepository.save(member1);
        Long memberId22 = memberJpaRepository.save(member11);
        Member member3 = memberJpaRepository.findById(memberId2).get();
        Member member33 = memberJpaRepository.findById(memberId22).get();


        Assertions.assertThat(member1.getName()).isEqualTo(member3.getName());
        Assertions.assertThat(member11.getName()).isEqualTo(member33.getName());
        // 카운트
        long count = memberJpaRepository.count();
        Assertions.assertThat(count).isEqualTo(2);

        //리스트 찾기
        List<Member> memberList = memberJpaRepository.findAll();
        Assertions.assertThat(memberList.size()).isEqualTo(2);
        //제거
        memberJpaRepository.remove(member1);
        memberJpaRepository.remove(member11);

        Member member5 = memberJpaRepository.findById(memberId2).get();
        Member member55 = memberJpaRepository.findById(memberId22).get();

        Assertions.assertThat(member5.getName()).isEqualTo(null);
        Assertions.assertThat(member55.getName()).isEqualTo(null);
    }
}