package com.example.Spring.Ecommerce.Project.Dto;

import lombok.Data;

@Data
public class CartResponse {
    String prodName;
    Integer quantiy;
    String message;

    public CartResponse(String message) {
        this.message = message;
    }

    public CartResponse(String prodName, Integer quantiy, String message) {
        this.prodName = prodName;
        this.quantiy = quantiy;
        this.message = message;
    }
}
