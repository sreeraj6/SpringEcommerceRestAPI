package com.example.Spring.Ecommerce.Project.Repository;

import com.example.Spring.Ecommerce.Project.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

}
