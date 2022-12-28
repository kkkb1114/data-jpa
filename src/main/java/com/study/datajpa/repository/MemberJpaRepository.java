package com.study.datajpa.repository;

import com.study.datajpa.entity.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Transactional
public class MemberJpaRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public Long save(Member member) {
        entityManager.persist(member);
        return member.getId();
    }

    public List<Member> findAll() {
        return entityManager.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    public Optional<Member> findById(Long id){
        return Optional.ofNullable(entityManager.find(Member.class, id));
    }

    public long count(){
        return entityManager.createQuery("select count(m) from Member m", Long.class)
                .getSingleResult();
    }

    public void remove(Member member) {
        entityManager.remove(member);
    }

    public Member findOne(Long id) {
        return entityManager.find(Member.class, id);
    }
}
