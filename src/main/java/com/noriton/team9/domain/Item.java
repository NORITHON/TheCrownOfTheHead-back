package com.noriton.team9.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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

    private int count;

    @OneToMany(mappedBy = "item")
    @JsonIgnore(value = false)
    private List<Orders> fundingList = new ArrayList<>();
    public void removeStockQuantity(int count) {
        int resStock = this.stockQuantity - count;
        if(resStock < 0){
            throw new IllegalStateException("펀딩 한계치를 초과했습니다.");
        }
        this.count += count;
        this.stockQuantity -= count;
    }

    public void addStockQuantity(int count) {
        this.count -= count;
        this.stockQuantity += count;
    }
}
