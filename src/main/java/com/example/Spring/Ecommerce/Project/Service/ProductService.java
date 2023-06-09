package com.example.Spring.Ecommerce.Project.Service;

import com.example.Spring.Ecommerce.Project.Dto.CommonResponse;
import com.example.Spring.Ecommerce.Project.Dto.ProductRequest;
import com.example.Spring.Ecommerce.Project.Model.ConfirmOrder;
import com.example.Spring.Ecommerce.Project.Model.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {

    Product addProduct(Product product);
    ResponseEntity<?> updateProduct(Long productId, Product product);
    List<Product> listProducts();

    ProductRequest deleteProduct(Long productId);
    List<ConfirmOrder>  getLiveOrders();
    CommonResponse updateOrderStatus(Long order_id);
}
