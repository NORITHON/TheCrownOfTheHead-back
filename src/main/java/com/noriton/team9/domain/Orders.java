package com.noriton.team9.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "item_id")
    @JsonManagedReference
    private Item item;
    private LocalDateTime orderDate;

    private int totalPrice;

    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "member_id")
    @JsonManagedReference
    private Member member;

    private String fundStatus;

    //==생성 메서드==//
    // 펀딩 생성
    public static Orders createOrder(int count, String address, String size, String phoneNumber, Member member, Item item, String fundStatus){
        Orders order = new Orders();
        order.setCount(count);
        order.setAddress(address);
        order.setSize(size);
        order.setPhoneNumber(phoneNumber);
        order.setMember(member);
        order.setItemRelation(item);
        order.setFundStatus(fundStatus);
        order.setOrderDate(LocalDateTime.now());
        order.setTotalPrice(count * item.getPrice());

        return order;
    }

    private void setItemRelation(Item item) {
        this.item = item;
        item.getFundingList().add(this);
    }

    public static Orders approveOrder(Item item, String fundStatus) {
        Orders order = new Orders();
        order.setFundStatus(fundStatus);    // approved
        order.setOrderDate(LocalDateTime.now());
        int totalCount=0, totalPrice=0;
        List<Orders> fundingList = item.getFundingList();
        for(int i=0; i<fundingList.size(); i++){
            totalCount += fundingList.get(i).count;
            totalPrice += fundingList.get(i).totalPrice;
            fundingList.get(i).setFundStatus(fundStatus);
        }
        order.setCount(totalCount);
        order.setTotalPrice(totalPrice);
        order.setItem(item);
        System.out.println(item.getName());
        order.setMember(item.getFundingList().get(0).getMember());
        return order;
    }

    // approved된 order는 Item의 fundingList에 하위로 들어가지 않는다. 단방향 관계.
//    private void setApprovedItem(Item item) {
//        this.item = item;
//    }

    public void setMember(Member member){
        this.member = member;
        member.getOrdersList().add(this);
    }

}
