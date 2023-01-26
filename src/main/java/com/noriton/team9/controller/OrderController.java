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
     * 주문생성
     * */
    @PostMapping("/order")
    public ResponseEntity<Orders> createOrder(@RequestBody OrderCreationRequest request){
        return ResponseEntity.ok(orderService.saveOrder(request.getAddress(), request.getSize(), request.getCount(), request.getPhoneNumber(), request.getMemberId(), request.getItemId()));
    }

    /**
     * 주문 전체 조회
     * */
    @GetMapping("/order")
    public ResponseEntity readOrders(){
        return ResponseEntity.ok(orderService.findOrders());
    }

    /**
     * 주문 삭제 -> 주문 상품에 대해 발송처리 된 경우
     * */
    @DeleteMapping("/order/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long orderId){
        orderService.deleteOrder(orderId);
        return ResponseEntity.ok().build();
    }

}
