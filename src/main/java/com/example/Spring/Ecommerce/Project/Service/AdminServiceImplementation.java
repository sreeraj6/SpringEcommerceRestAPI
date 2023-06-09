package com.example.Spring.Ecommerce.Project.Service;

import com.example.Spring.Ecommerce.Project.Dto.CommonResponse;
import com.example.Spring.Ecommerce.Project.Model.Admin;
import com.example.Spring.Ecommerce.Project.Model.ConfirmOrder;
import com.example.Spring.Ecommerce.Project.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImplementation implements AdminService{

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private ProductService productService;

    @Override
    public Admin addAdmin(Admin newAdmin) {
        return adminRepository.save(newAdmin);
    }

    @Override
    public List<ConfirmOrder> getLiveOrder() {
        List<ConfirmOrder> list =  productService.getLiveOrders();
        System.out.println(list);
        return list;
    }

    @Override
    public CommonResponse updateOrderStatus(Long order_id) {
        return productService.updateOrderStatus(order_id);
    }
}
