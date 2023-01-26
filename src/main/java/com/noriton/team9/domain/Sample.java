package com.noriton.team9.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private Designer designer;

    public void settingDesigner(Designer designer) {
        this.designer = designer;
        designer.getSamples().add(this);
    }
}
