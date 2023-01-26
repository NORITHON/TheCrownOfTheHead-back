package com.noriton.team9.service;

import com.noriton.team9.domain.Member;
import com.noriton.team9.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    /**
     * 전체 회원 조회
     * */
    public List<Member> readMembers(){
        return memberRepository.findAll();
    }

    /**
     * 회원가입
     * */
    @Transactional
    public Member createMember(String loginId, String password){
        Member member = Member.createMember(loginId, password);
        return memberRepository.save(member);
    }

    /**
     * 조회 by id
     * */
    public Member findById(Long memberId){
        return memberRepository.findOne(memberId);
    }


    /**
     * 로그인 : 조회 by loginId
     * */
    public Member login(String loginId, String password){
        List<Member> getMembers = memberRepository.findByLoginId(loginId);
        if(getMembers.size() == 0) return new Member();
        int flag = 0;   // 비밀번호가 일치한 member가 없는 경우
        int memberIdx=0;
        for(int i=0; i<getMembers.size(); i++){
            if(getMembers.get(i).getPassword().compareTo(password) == 0) {
                flag = 1;
                memberIdx = i;
                break;
            }
        }

        if(flag == 0) return new Member();
        return getMembers.get(memberIdx);
    }

    /**
     * 회원탈퇴
     * */
    @Transactional
    public void deleteMember(Long memberId){
        memberRepository.delete(memberId);
    }

}
