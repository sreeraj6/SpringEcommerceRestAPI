package com.example.Spring.Ecommerce.Project.Controller;

import com.example.Spring.Ecommerce.Project.Dto.ProductRequest;
import com.example.Spring.Ecommerce.Project.Model.Product;
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

    @PostMapping("/update-product/{pid}")
    public Product updateProduct(@PathVariable("pid") Long pid, @RequestBody Product product) {
        return productService.updateProduct(pid,product);
    }

    @PostMapping("/delete-product/{pid}")
    public ProductRequest deleteProduct(@PathVariable("pid") Long prodId) {
        return productService.deleteProduct(prodId);
    }
}
