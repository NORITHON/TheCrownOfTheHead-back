package com.noriton.team9.service;

import com.noriton.team9.domain.Item;
import com.noriton.team9.domain.Member;
import com.noriton.team9.domain.Orders;
import com.noriton.team9.repository.ItemRepository;
import com.noriton.team9.repository.MemberRepository;
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
    private final MemberRepository memberRepository;


    /**
     * 펀딩 생성
     */
    @Transactional
    public Orders saveOrder(String address, String size, int count, String phoneNumber, Long memberId, Long itemId) {
        // 엔티티 조회
        Optional<Item> optionalItem = itemRepository.findById(itemId);
        Member member = memberRepository.findOne(memberId);
        // Todo : itemId를 pk로 가지는 item이 없는 경우 exception터트리기
        Item item = optionalItem.get();
        item.removeStockQuantity(count);

        Orders order = Orders.createOrder(count, address, size, phoneNumber, member, item, "WAITING");
        return orderRepository.save(order);
    }

    /**
     * 펀딩 전체 조회
     */
    public List<Orders> findOrders() {
        return orderRepository.findAll();
    }

    /**
     * 펀딩 삭제 -> 마이페이지에서 취소
     */
    @Transactional
    public void deleteOrder(Long orderId) {
        // 엔티티 조회
        List<Orders> order = orderRepository.findById(orderId);
        Item item = order.get(0).getItem();
        item.addStockQuantity(order.get(0).getCount());
        orderRepository.delete(orderId);
    }

    /**
     * 펀딩 조회 - 상품별 : 관리자 페이지에서 조회
     */
    public List<Orders> findOrdersByItem(Long itemId) {
        return orderRepository.findByItem(itemId);
    }

    /**
     * 펀딩 조회 - 멤버별 : 마이페이지에서 내가 펀딩한 상품 보기
     * */
//    public List<Orders> findOrdersByMember(Long memberId) { return orderRepository.findByMember(memberId);}


    /**
     * 주문 승인
     */
    @Transactional
    public Orders approveOrder(Long itemId) {
        Optional<Item> optionalItem = itemRepository.findById(itemId);
        Item item = optionalItem.get();

        Orders order = Orders.approveOrder(item, "APPROVED");

        List<Orders> list = item.getFundingList();
        for (int i = 0; i < list.size(); i++) {
            orderRepository.save(list.get(i));
        }
        return orderRepository.save(order);
    }

    public List<Orders> readOrders() {
        return orderRepository.findAll();
    }

    /**
     * 주문 조회 by id
     * */

}
