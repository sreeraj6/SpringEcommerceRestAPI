package com.example.Spring.Ecommerce.Project.Service;

import com.example.Spring.Ecommerce.Project.Dto.CartResponse;
import com.example.Spring.Ecommerce.Project.Dto.OrderResponse;
import com.example.Spring.Ecommerce.Project.Dto.PayModeAndAddress;
import com.example.Spring.Ecommerce.Project.Dto.PlacedResponse;
import com.example.Spring.Ecommerce.Project.Model.Cart;
import com.example.Spring.Ecommerce.Project.Model.ConfirmOrder;
import com.example.Spring.Ecommerce.Project.Model.Product;
import com.example.Spring.Ecommerce.Project.Model.StageOrder;
import com.example.Spring.Ecommerce.Project.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductService productService;

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private StageOrderRepository stageOrderRepository;

    @Autowired
    private ConfirmOrderRepository confirmOrderRepository;

    @Override
    public List<Product> getProducts() {
        return productService.listProducts();
    }

    @Override
    public CartResponse addToCart(Long proId, String username) {

        try {
            Optional<Cart> cartList = cartRepository.findProductByUserIdProId(username, proId);
            Cart cartItem;
            if(cartList.isPresent()) {
                cartItem = cartList.get();
                cartItem.setQuantity(cartItem.getQuantity()+1);
            }
            else{
                cartItem = new Cart(proId,username,1);
            }
            cartRepository.save(cartItem);
            Product product = productRepository.getById(proId);
            return new CartResponse(product.getPname(), cartItem.getQuantity(), "Item added to cart Successfully");
        }
        catch (Exception e) {
            return new CartResponse("Error occured");
        }

    }

    @Override
    public List<Product> getCartProduct(String username) {
        List<Cart> cartItems = cartRepository.findByUsername(username);
        List<Product> cartProducts = new ArrayList<>();
        for(Cart item : cartItems) {
            if(item.getStatus() != 0) {
                Product product = productRepository.getById(item.getProId());
                if(product.getQuantity() >= item.getQuantity()){
                    cartProducts.add(product);
                }
            }
        }
        return cartProducts;
    }

    @Override
    public OrderResponse orderNow(String  username, List<Product> productList) {
        return null;
    }

    @Override
    public OrderResponse orderNow(String  username, Product product) {
        Cart cartItem = cartRepository.findProductByUserIdProId(username, product.getPid()).get();
        StageOrder order = new StageOrder(cartItem,product,username);
        StageOrder savedOrder = stageOrderRepository.save(order);
        return new OrderResponse(savedOrder.getStg_oid(),product.getPid(),product.getPname(),cartItem.getQuantity(),product.getPrice(),savedOrder.getTotalprice());
    }

    @Override
    public PlacedResponse placeOrder(Long stg_id, PayModeAndAddress payModeAndAddress) {
        StageOrder stageOrder = stageOrderRepository.getById(stg_id);
        try {
            Product product = productRepository.getById(stageOrder.getPid());
            if(product.getQuantity() >= stageOrder.getQuantity()) {
                ConfirmOrder confirmOrder = new ConfirmOrder(stageOrder,payModeAndAddress);
                product.setQuantity(product.getQuantity()-stageOrder.getQuantity());
                productRepository.save(product);
                stageOrderRepository.deleteById(stg_id);
                cartRepository.deleteById(stageOrder.getCartId());
                return new PlacedResponse("Order Placed Successfully");
            }
            return new PlacedResponse("Error Occured");
        }
        catch (Exception e) {
            return new PlacedResponse("Error Occured");
        }

    }
}
