package com.noriton.team9.request;

import lombok.Data;

@Data
public class ItemCreationRequest {
    private String name;
    private int laborCost;
    private int materialCost;

    private Long sampleId;
    private int stockQuantity;
}
