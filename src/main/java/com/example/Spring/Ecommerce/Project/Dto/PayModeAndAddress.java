package com.example.Spring.Ecommerce.Project.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayModeAndAddress {
    private String address;
    private String pincode;
    private String paymentMode;
}
