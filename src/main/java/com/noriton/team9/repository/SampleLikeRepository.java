package com.noriton.team9.repository;

import com.noriton.team9.domain.Orders;
import com.noriton.team9.domain.SampleLike;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@RequiredArgsConstructor
public class SampleLikeRepository {

    private final EntityManager em;
    public SampleLike save(SampleLike sampleLike) {
        em.persist(sampleLike);
        return sampleLike;
    }

    public List<SampleLike> findBySampleId(Long sampleId){
        return em.createQuery("select s from SampleLike s where s.sample.id = :id")
                .setParameter("id", sampleId)
                .getResultList();
    }

    public void deleteOne(Long sampleId, Long memberId) {
        em.createQuery("delete from SampleLike s where s.sample.id = :sampleId and s.member.id = :memberId")
                .setParameter("sampleId", sampleId)
                .setParameter("memberId", memberId)
                .getResultList();
//        em.remove(result.get(0));
    }

    public List<SampleLike> findbySampleAndMember(Long sampleId, Long memberId){
        return em.createQuery("select sl from SampleLike sl where sl.member.id = :memberId and sl.sample.id = :sampleId")
                .setParameter("memberId", memberId)
                .setParameter("sampleId", sampleId)
                .getResultList();
    }

//    public SampleLike findById(Long sampleId) {
//        return em.find(SampleLike.class,sampleId);
//    }
}
