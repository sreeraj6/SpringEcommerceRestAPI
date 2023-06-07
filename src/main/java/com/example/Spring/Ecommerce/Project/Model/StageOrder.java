package com.example.Spring.Ecommerce.Project.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "stg_order")
public class StageOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stg_oid")
    private Long stg_oid;
    @Column(name = "cartid")
    private Long cartId;
    @Column(name = "pid")
    private Long pid;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "price")
    private Integer price;
    @Column(name = "totalprice")
    private Integer totalprice;

    @Column(name = "username")
    private String username;

    public StageOrder(Cart cart, Product product, String username) {
        cartId = cart.getCartId();
        pid = product.getPid();
        quantity = cart.getQuantity();
        price = product.getPrice();
        totalprice = price * quantity;
        this.username = username;
    }
}
