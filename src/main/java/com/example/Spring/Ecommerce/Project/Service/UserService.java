package com.example.Spring.Ecommerce.Project.Service;

import com.example.Spring.Ecommerce.Project.Dto.CartResponse;
import com.example.Spring.Ecommerce.Project.Dto.OrderResponse;
import com.example.Spring.Ecommerce.Project.Dto.PayModeAndAddress;
import com.example.Spring.Ecommerce.Project.Dto.PlacedResponse;
import com.example.Spring.Ecommerce.Project.Model.Product;

import java.util.List;

public interface UserService {

        List<Product> getProducts();
        CartResponse addToCart(Long proId, String username);
        List<Product> getCartProduct(String username);
        OrderResponse orderNow(String  username, List<Product> productList);
        OrderResponse orderNow(String  username, Product product);

        PlacedResponse placeOrder(Long stg_id, PayModeAndAddress payModeAndAddress);
}
