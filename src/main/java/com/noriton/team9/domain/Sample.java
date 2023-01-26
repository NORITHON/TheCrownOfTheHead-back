package com.noriton.team9.domain;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "sample")
public class Sample {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sample_id")
    private Long id;

    private String title;
    private String imageUrl;
    private String content;

    @ManyToOne
    @JoinColumn(name = "designer_id")
    @JsonManagedReference
    private Designer designer;
}
