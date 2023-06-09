package com.example.Spring.Ecommerce.Project.Service;

import com.example.Spring.Ecommerce.Project.Dto.CommonResponse;
import com.example.Spring.Ecommerce.Project.Dto.ProductRequest;
import com.example.Spring.Ecommerce.Project.Model.ConfirmOrder;
import com.example.Spring.Ecommerce.Project.Model.Product;
import com.example.Spring.Ecommerce.Project.Repository.CartRepository;
import com.example.Spring.Ecommerce.Project.Repository.ConfirmOrderRepository;
import com.example.Spring.Ecommerce.Project.Repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImplementation implements ProductService{


    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ConfirmOrderRepository confirmOrderRepository;
    @Autowired
    private CartRepository cartRepository;

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public ResponseEntity<?> updateProduct(Long productId, Product updatedProduct) {
        try {
            Product existProduct = productRepository.getById(productId);
            if(updatedProduct.getPname() != null && !existProduct.getPname().equals(updatedProduct.getPname())) {
                existProduct.setPname(updatedProduct.getPname());
            }
            if(updatedProduct.getCategory() != null && !existProduct.getCategory().equals(updatedProduct.getCategory())) {
                existProduct.setCategory(updatedProduct.getCategory());
            }
            if(updatedProduct.getQuantity() != null && existProduct.getQuantity() != updatedProduct.getQuantity()) {
                existProduct.setQuantity(updatedProduct.getQuantity());
            }
            if(updatedProduct.getPrice() != null && existProduct.getPrice() != updatedProduct.getPrice()) {
                existProduct.setPrice(updatedProduct.getPrice());
            }
            return ResponseEntity.ok(productRepository.save(existProduct));
        }
        catch (EntityNotFoundException e){
            return new ResponseEntity<>("Invalid product id", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public List<Product> listProducts() {
        return productRepository.findAll();
    }

    @Override
    public ProductRequest deleteProduct(Long productId) {
        try {
            productRepository.deleteById(productId);
            return new ProductRequest(new Date().toString(), "Succesfully Deleted");
        }
        catch (Exception e) {
            return new ProductRequest(new Date().toString(), "Invalid productid");
        }
    }

    @Override
    public List<ConfirmOrder> getLiveOrders() {
        return confirmOrderRepository.findByStatus();
    }

    @Override
    public CommonResponse updateOrderStatus(Long order_id) {
        try {
            ConfirmOrder order = confirmOrderRepository.getById(order_id);
            if (order.isUpdateEnable()){
                if(order.getStatus() >= 4) {
                    order.setStatus(0);
                }
                else{
                    order.setStatus(order.getStatus()+1);
                }
                confirmOrderRepository.save(order);
                return new CommonResponse("Order status updated", true);
            }
            return new CommonResponse("Order Delivered no more update possible", false);
        }
        catch (Exception e) {
            return new CommonResponse("Error occured", false);
        }
    }
}
