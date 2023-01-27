package com.noriton.team9.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
public class SampleLike {

    @Id @GeneratedValue
    @Column(name = "sampleLike_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sample_id")
    @JsonManagedReference
    private Sample sample;

    @ManyToOne
    @JoinColumn(name = "member_id")
    @JsonManagedReference
    private Member member;

    @Enumerated(EnumType.ORDINAL)
    private LikeStatus status;

}
