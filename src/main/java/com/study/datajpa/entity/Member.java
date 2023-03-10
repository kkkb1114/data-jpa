package com.study.datajpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "name", "age"}) //toString()동작시 출력하는 어노테이션
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String name;
    private int age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    public Member(String name, int age, Team team){
        this.name = name;
        this.age = age;
        if (team != null){
            this.team = team;
        }
    }

    public void changeName(String name){
        this.name = name;
    }

    public void changeTeam(Team team){
        this.team = team;
        team.getMemberList().add(this);
    }
}
