package com.example.Spring.Ecommerce.Project.Service;

import com.example.Spring.Ecommerce.Project.Dto.ProductRequest;
import com.example.Spring.Ecommerce.Project.Model.Product;

import java.util.List;

public interface ProductService {

    Product addProduct(Product product);
    Product updateProduct(Long productId, Product product);
    List<Product> listProducts();

    ProductRequest deleteProduct(Long productId);
}
