package com.noriton.team9.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    private int count;

    private String address;

    private String size;

    @OneToOne
    @JoinColumn(name = "item_id")
    private Item item;
    private LocalDateTime orderDate;

    private int totalPrice;

    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private String fundStatus;

    //==생성 메서드==//
    public static Orders createOrder(int count, String address, String size, String phoneNumber, Member member, Item item, String fundStatus){
        Orders order = new Orders();
        order.setCount(count);
        order.setAddress(address);
        order.setSize(size);
        order.setPhoneNumber(phoneNumber);
        order.setMember(member);
        order.setItem(item);
        order.setFundStatus(fundStatus);
        order.setOrderDate(LocalDateTime.now());
        order.setTotalPrice(count * item.getPrice());
        return order;
    }

    public void setMember(Member member){
        this.member = member;
        member.getOrdersList().add(this);
    }

}
