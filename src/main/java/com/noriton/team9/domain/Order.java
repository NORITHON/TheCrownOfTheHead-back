package com.noriton.team9.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {

    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    private int count;

    private String address;

    private String size;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;
    private LocalDateTime orderDate;

    private int totalPrice;

    //==생성 메서드==//
    public static Order createOrder(int count, String address, String size, Item item){
        Order order = new Order();
        order.setCount(count);
        order.setAddress(address);
        order.setSize(size);
        order.setItem(item);
        order.setOrderDate(LocalDateTime.now());
        order.setTotalPrice(count * item.getPrice());
        return order;
    }


}
