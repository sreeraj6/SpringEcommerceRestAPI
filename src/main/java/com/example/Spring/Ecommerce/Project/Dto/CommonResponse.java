package com.example.Spring.Ecommerce.Project.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResponse {
    private String message;
    private boolean status;

    public boolean isTrue() {
        return status;
    }
}
