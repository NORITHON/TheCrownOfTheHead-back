package com.noriton.team9.service;

import com.noriton.team9.domain.Item;
import com.noriton.team9.domain.Orders;
import com.noriton.team9.repository.ItemRepository;
import com.noriton.team9.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;

    /**
     * 주문 생성
     * */
    @Transactional
    public Orders saveOrder(String address, String size, int count, Long itemId){
        // 엔티티 조회
        Optional<Item> optionalItem = itemRepository.findById(itemId);
        // Todo : itemId를 pk로 가지는 item이 없는 경우 exception터트리기
        Item item = optionalItem.get();

        Orders order = Orders.createOrder(count, address, size, item);
        return orderRepository.save(order);
    }

    /**
     * 주문 전체 조회
     * */
    public List<Orders> findOrders() {
        return orderRepository.findAll();
    }

}
