package com.example.Spring.Ecommerce.Project.Repository;

import com.example.Spring.Ecommerce.Project.Model.ConfirmOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConfirmOrderRepository extends JpaRepository<ConfirmOrder, Long> {

    @Query(value = "select * from confirm_order where status > 0", nativeQuery = true)
    List<ConfirmOrder> findByStatus();
}
