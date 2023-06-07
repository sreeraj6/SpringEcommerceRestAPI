package com.example.Spring.Ecommerce.Project.Dto;

import com.example.Spring.Ecommerce.Project.Model.StageOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private Long stg_id;
    private Long cartId;
    private String pname;
    private int quantity;
    private int price;
    private int total;


}
