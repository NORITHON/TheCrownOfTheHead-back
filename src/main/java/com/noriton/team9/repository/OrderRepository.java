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
     * 주문 생성
     * */
    public Orders save(Orders order){
        em.persist(order);
        return order;
    }

    /**
     * 주문 전체 조회
     * */
    public List<Orders> findAll(){
        return em.createQuery("select o from Orders o", Orders.class)
                .getResultList();
    }

    /**
     * 주문 삭제 -> 상품 발송을 완료한 경우
     * */
    public void delete(Long orderId){
        Orders getOrder = em.find(Orders.class, orderId);
        em.remove(getOrder);
    }

}
