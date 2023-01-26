package com.noriton.team9.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "member")
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String loginId;
    private String password;

    @OneToMany(mappedBy = "member")
    private List<Orders> ordersList = new ArrayList<>();

    public static Member createMember(String loginId, String password){
        Member member = new Member();
        member.setLoginId(loginId);
        member.setPassword(password);
        return member;
    }


}
