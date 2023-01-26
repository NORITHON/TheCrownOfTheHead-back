package com.noriton.team9.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Item {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;

    private int price;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sample_id")
    private Sample sample;
}
