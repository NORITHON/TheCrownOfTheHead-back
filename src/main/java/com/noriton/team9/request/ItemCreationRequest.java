package com.noriton.team9.request;

import lombok.Data;

@Data
public class ItemCreationRequest {
    private String name;

    private int laborCost;  //인건비
    private int materialCost;  //원자재값
    private int circulationCost;  //유통비

    private Long sampleId;
    private int stockQuantity;
}
