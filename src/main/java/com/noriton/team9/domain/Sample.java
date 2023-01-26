package com.noriton.team9.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Sample {

    @Id
    @GeneratedValue
    @Column(name = "sample_id")
    private Long id;

    private String title;
    private String imageUrl;
    private String content;
}
