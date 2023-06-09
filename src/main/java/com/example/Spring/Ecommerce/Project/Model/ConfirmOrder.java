package com.example.Spring.Ecommerce.Project.Model;

import com.example.Spring.Ecommerce.Project.Dto.PayModeAndAddress;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "confirm_order")
public class ConfirmOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long order_id;
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
    @Column(name = "address")
    private String address;
    @Column(name = "pincode")
    private String pincode;
    @Column(name = "paymode")
    private String payMode;
    @Column(name = "status")
    private int status;

    public ConfirmOrder(StageOrder stageOrder, PayModeAndAddress payModeAndAddress,int status) {
        cartId = stageOrder.getCartId();
        pid = stageOrder.getPid();
        quantity = stageOrder.getQuantity();
        price = stageOrder.getPrice();
        totalprice = stageOrder.getTotalprice();
        username = stageOrder.getUsername();
        address = payModeAndAddress.getAddress();
        pincode = payModeAndAddress.getPincode();
        payMode = payModeAndAddress.getPaymentMode();
        this.status = status;
    }

    public boolean isUpdateEnable() {
        if(status == 0) {
            return false;
        }
        return true;
    }
}
