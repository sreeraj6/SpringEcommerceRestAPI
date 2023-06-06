package com.example.Spring.Ecommerce.Project.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cartId")
    Long cartId;

    @Column(name = "prodId")
    Long proId;

    @Column(name = "userId")
    Long userId;

    @Column(name = "quantity")
    Integer quantity;
}
