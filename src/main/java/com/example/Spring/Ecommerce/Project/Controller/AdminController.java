package com.example.Spring.Ecommerce.Project.Controller;

import com.example.Spring.Ecommerce.Project.Dto.CommonResponse;
import com.example.Spring.Ecommerce.Project.Dto.ProductRequest;
import com.example.Spring.Ecommerce.Project.Model.Product;
import com.example.Spring.Ecommerce.Project.Service.AdminService;
import com.example.Spring.Ecommerce.Project.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/admin")
public class AdminController {

    @Autowired
    ProductService productService;
    @Autowired
    private AdminService adminService;

    @GetMapping("/login")
    public String loginGet() {
        return "hello welcome";
    }

    @PostMapping("/add-product")
    public Product addProduct(@RequestBody Product newProduct) {
        return productService.addProduct(newProduct);
    }

    @GetMapping("/list-product")
    public ResponseEntity<?> getProducts() {
        List<Product> products =  productService.listProducts();
        if(products.isEmpty()){
            return new ResponseEntity<>("No product found", HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(products);
    }

    @PutMapping("/update-product/{pid}")
    public ResponseEntity<?> updateProduct(@PathVariable("pid") Long pid, @RequestBody Product product) {
        return productService.updateProduct(pid,product);
    }

    @DeleteMapping("/delete-product/{pid}")
    public ProductRequest deleteProduct(@PathVariable("pid") Long prodId) {
        return productService.deleteProduct(prodId);
    }

    @GetMapping("/get-orders")
    public ResponseEntity<?> getOrders() {
        return ResponseEntity.ok(adminService.getLiveOrder());
    }

    @PutMapping("/update-status/{oid}")
    public ResponseEntity<?> updateOrderStatus(@PathVariable("oid") Long oid) {
        CommonResponse commonResponse = adminService.updateOrderStatus(oid);
        if(commonResponse.isTrue()) {
            return ResponseEntity.ok(commonResponse);
        }
        return new ResponseEntity<>(commonResponse, HttpStatus.BAD_REQUEST);
    }
}
