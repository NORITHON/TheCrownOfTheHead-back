package com.noriton.team9.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "sample")
public class Sample{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sample_id")
    private Long id;

    private String title;
    private String imageUrl;
    private String content;

//    @ManyToMany(mappedBy = "likedSamples")
//    private List<Member> likedMembers = new ArrayList<>();

    private int likeCount;

    @ManyToOne
    @JoinColumn(name = "designer_id")
    @JsonIgnore
    private Designer designer;

    public void settingDesigner(Designer designer) {
        this.designer = designer;
        designer.getSamples().add(this);
    }

//    @Override
//    public int compareTo(Sample s) {
//        if (s.likeCount < likeCount) {
//            return 1;
//        } else if (s.likeCount > likeCount) {
//            return -1;
//        }
//        return 0;
//    }
}
