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
    public Cart(Long proId, String username, Integer quantity, Integer status) {
        this.proId = proId;
        this.username = username;
        this.quantity = quantity;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cartid")
    Long cartId;

    @Column(name = "proid")
    Long proId;

    @Column(name = "username")
    String username;

    @Column(name = "quantity")
    Integer quantity;

    @Column(name = "status")
    Integer status;
}
