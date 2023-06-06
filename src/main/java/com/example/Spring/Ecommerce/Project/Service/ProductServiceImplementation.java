package com.example.Spring.Ecommerce.Project.Service;

import com.example.Spring.Ecommerce.Project.Dto.ProductRequest;
import com.example.Spring.Ecommerce.Project.Model.Product;
import com.example.Spring.Ecommerce.Project.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImplementation implements ProductService{


    @Autowired
    ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long productId, Product updatedProduct) {
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
        return productRepository.save(existProduct);
    }

    @Override
    public List<Product> listProducts() {
        return productRepository.findAll();
    }

    @Override
    public ProductRequest deleteProduct(Long productId) {
        productRepository.deleteById(productId);
        return new ProductRequest(new Date().toString(), "Succesfully Deleted");
    }
}
