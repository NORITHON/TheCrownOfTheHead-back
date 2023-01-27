package com.noriton.team9.controller;

import com.noriton.team9.domain.Orders;
import com.noriton.team9.request.OrderCreationRequest;
import com.noriton.team9.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {

    private final OrderService orderService;

    /**
     * 펀딩참여
     * */
    @PostMapping("/fund")
    public ResponseEntity<Orders> createOrder(@RequestBody OrderCreationRequest request){
        return ResponseEntity.ok(orderService.saveOrder(request.getAddress(), request.getSize(), request.getCount(), request.getPhoneNumber(), request.getMemberId(), request.getItemId()));
    }

    /**
     * 주문 승인
     * */
    @PostMapping("/order")
    public ResponseEntity<Orders> approveOrder(@RequestBody OrderCreationRequest request){
        return ResponseEntity.ok(orderService.approveOrder(request.getItemId()));
    }

    /**
     * 상품(승인, 미승인 상관 없이) 전체 조회
     * */
    @GetMapping("/order")
    public ResponseEntity readAllOrders(){
        return ResponseEntity.ok(orderService.findOrders());
    }

//    /**
//     * 펀딩 전체 조회
//     * */
//    @GetMapping("/fund")
//    public ResponseEntity readOrders(){
//        return ResponseEntity.ok(orderService.findOrders());
//    }

    /**
     * 상품별 펀딩 조회
     * */
    @GetMapping("/fund/{itemId}")
    public ResponseEntity readOrdersByItem(@PathVariable Long itemId){
        return ResponseEntity.ok(orderService.findOrdersByItem(itemId));
    }


    /**
     * 펀딩 취소 -> 주문 상품에 대해 발송처리 된 경우
     * */
    @DeleteMapping("/fund/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long orderId){
        orderService.deleteOrder(orderId);
        return ResponseEntity.ok().build();
    }

    /**
     * 승인된 상품 memberId로 조회 -> 마이페이지
     * */
    @PostMapping("/order/{memberId}")
    public ResponseEntity readOrdersByMemberId(@PathVariable Long memberId)
    {
        return ResponseEntity.ok(orderService.findOrdersByMemberId(memberId));
    }

    /**
     * 승인된 상품 전체 조회 -> 관리자 페이지
     * */
    @GetMapping("/order/approved")
    public ResponseEntity readApprovedOrders(){
        return ResponseEntity.ok(orderService.readApprovedOrders());
    }
}
