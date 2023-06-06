package com.example.Spring.Ecommerce.Project.Repository;

import com.example.Spring.Ecommerce.Project.Model.Cart;
import com.example.Spring.Ecommerce.Project.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    public Optional<Product> findProductByUserIdProId(Long userId, Long proId);
}
