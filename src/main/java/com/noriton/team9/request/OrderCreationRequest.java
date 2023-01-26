package com.noriton.team9.request;

import lombok.Data;

@Data
public class OrderCreationRequest {
    private String address;
    private String size;
    private int count;
    private Long itemId;
    private String phoneNumber;
}
