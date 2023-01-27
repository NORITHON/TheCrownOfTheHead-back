package com.noriton.team9.repository;

import com.noriton.team9.domain.Orders;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderRepository {

    private final EntityManager em;

    /**
     * 펀딩 생성
     * */
    public Orders save(Orders order){
        em.persist(order);
        return order;
    }

    /**
     * 펀딩 전체 조회
     * */
    public List<Orders> findAll(){
        return em.createQuery("select o from Orders o where o.fundStatus = :fundStatus", Orders.class)
                .setParameter("fundStatus", "WAITING")
                .getResultList();
    }

    /**
     * 펀딩 취소
     * */
    public void delete(Long orderId){
        Orders getOrder = em.find(Orders.class, orderId);
        em.remove(getOrder);
    }

    /**
     * 펀딩 조회 - 상품별
     * */
    public List<Orders> findByItem(Long itemId) {
        return em.createQuery("select o from Orders o where o.item.id = :itemId and o.fundStatus = :fundStatus")
                .setParameter("id", itemId)
                .setParameter("fundStatus", "WAITING")
                .getResultList();
    }

    /**
     * 조회 by id
     * */
    public List<Orders> findById(Long memberId){
        return em.createQuery("select o from Orders o where o.id = :id")
                .setParameter("id", memberId)
                .getResultList();
    }

    public List<Orders> findByMemberId(Long memberId) {
        return em.createQuery("select o from Orders o where o.member.id = :memberId")
                .setParameter("memberId", memberId)
                .getResultList();
    }
}
