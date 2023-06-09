package com.example.Spring.Ecommerce.Project.Repository;

import com.example.Spring.Ecommerce.Project.Model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    @Query(value = "select * from cart where proid = :proId and username = :username", nativeQuery = true)
    Optional<Cart> findProductByUserIdProId(String username, Long proId);

    List<Cart> findByUsername(String username);

    @Query(value = "update cart set status = 1 where proid = :proId", nativeQuery = true)
    void updateStatusOfDeleted(Long proId);
}
