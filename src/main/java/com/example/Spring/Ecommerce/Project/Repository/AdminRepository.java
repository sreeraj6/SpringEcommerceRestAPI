package com.example.Spring.Ecommerce.Project.Repository;

import com.example.Spring.Ecommerce.Project.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
}
