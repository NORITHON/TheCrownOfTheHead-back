package com.noriton.team9.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String loginId;
    private String password;

    @OneToMany(mappedBy = "member")
    @JsonBackReference
    private List<Orders> ordersList = new ArrayList<>();

//    @ManyToMany(mappedBy = "likedMembers")
//    private List<Sample> likedSamples = new ArrayList<>();

    public static Member createMember(String loginId, String password){
        Member member = new Member();
        member.setLoginId(loginId);
        member.setPassword(password);
        return member;
    }


}
