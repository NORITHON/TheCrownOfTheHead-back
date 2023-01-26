package com.noriton.team9.service;

import com.noriton.team9.domain.Orders;
import com.noriton.team9.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    /**
     * 주문 생성
     * */
    public Orders saveOrder(Orders order){
        return orderRepository.save(order);
    }

    /**
     * 주문 전체 조회
     * */
    public List<Orders> findOrders() {
        return orderRepository.findAll();
    }

}
