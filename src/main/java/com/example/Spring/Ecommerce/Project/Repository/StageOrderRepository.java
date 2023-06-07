package com.example.Spring.Ecommerce.Project.Repository;

import com.example.Spring.Ecommerce.Project.Model.StageOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StageOrderRepository extends JpaRepository<StageOrder, Long> {
}
