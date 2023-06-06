package com.example.Spring.Ecommerce.Project.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "pid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long pid;
    @Column(name = "pname")
    String pname;
    @Column(name = "category")
    String category;
    @Column(name = "quantity")
    Integer quantity;
    @Column(name = "price")
    Integer price;
}
