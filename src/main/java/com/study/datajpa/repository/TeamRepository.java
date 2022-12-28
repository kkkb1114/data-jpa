package com.study.datajpa.repository;

import com.study.datajpa.entity.Member;
import com.study.datajpa.entity.Team;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TeamRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public Long save(Team team) {
        entityManager.persist(team);
        return team.getId();
    }

    public List<Team> findAll() {
        return entityManager.createQuery("select t from team t", Team.class)
                .getResultList();
    }

    public Optional<Team> findById(Long id){
        return Optional.ofNullable(entityManager.find(Team.class, id));
    }

    public long count(){
        return entityManager.createQuery("select count(t) team t", Long.class)
                .getSingleResult();
    }

    public void remove(Team team) {
        entityManager.remove(team);
    }

    public Team findOne(Long id) {
        return entityManager.find(Team.class, id);
    }
}
