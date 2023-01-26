package com.noriton.team9.repository;

import com.noriton.team9.domain.Member;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    /**
     * 멤버 생성
     * */
    public Member save(Member member){
        em.persist(member);
        return member;
    }

    /**
     * 멤버 조회 by id
     * */
    public Member findOne(Long memberId){
        return em.find(Member.class, memberId);
    }

    /**
     * 멤버 전체 조회
     * */
    public List<Member> findAll(){
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    /**
     * 멤버 조회 by loginId
     * */
    public List<Member> findByLoginId(String loginId){
        return em.createQuery("select m from Member m where loginId = :loginId")
                .setParameter("loginId", loginId)
                .getResultList();
    }

    /**
     * 멤버 삭제
     * */
    @Transactional
    public void delete(Long memberId){
        Member member = em.find(Member.class, memberId);
        em.remove(member);
    }

}
