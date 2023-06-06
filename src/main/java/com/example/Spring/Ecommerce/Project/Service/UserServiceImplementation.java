package com.example.Spring.Ecommerce.Project.Service;

import com.example.Spring.Ecommerce.Project.Dto.CartResponse;
import com.example.Spring.Ecommerce.Project.Dto.OrderResponse;
import com.example.Spring.Ecommerce.Project.Model.Product;
import com.example.Spring.Ecommerce.Project.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImplementation implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductService productService;

    @Override
    public List<Product> getProducts() {
        return productService.listProducts();
    }

    @Override
    public CartResponse addToCart(Long proId, Long userId) {
        return null;
    }

    @Override
    public OrderResponse orderNow(Long proId, List<Product> productList) {
        return null;
    }

    @Override
    public OrderResponse orderNow(Long proId, Product product) {
        return null;
    }
}
