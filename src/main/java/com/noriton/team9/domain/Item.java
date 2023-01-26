package com.noriton.team9.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;
    private String name;
    private int price;

    @OneToOne
    @JoinColumn(name = "sample_id")
    private Sample sample;

    private int stockQuantity;

    public void removeStockQuantity(int count) {
        int resStock = this.stockQuantity - count;
        if(resStock < 0){
            throw new IllegalStateException("펀딩 한계치를 초과했습니다.");
        }
        this.stockQuantity -= count;
    }

    public void addStockQuantity(int count) {
        this.stockQuantity += count;
    }
}
