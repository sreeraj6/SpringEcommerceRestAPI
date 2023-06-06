package com.example.Spring.Ecommerce.Project.Service;

import com.example.Spring.Ecommerce.Project.Dto.CartResponse;
import com.example.Spring.Ecommerce.Project.Dto.OrderResponse;
import com.example.Spring.Ecommerce.Project.Model.Product;

import java.util.List;

public interface UserService {

        List<Product> getProducts();

        CartResponse addToCart(Long proId, Long userid);

        OrderResponse orderNow(Long proId, List<Product> productList);

        OrderResponse orderNow(Long proId, Product product);
}
