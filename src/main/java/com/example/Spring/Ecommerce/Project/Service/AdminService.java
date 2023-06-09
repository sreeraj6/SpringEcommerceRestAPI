package com.example.Spring.Ecommerce.Project.Service;

import com.example.Spring.Ecommerce.Project.Dto.CommonResponse;
import com.example.Spring.Ecommerce.Project.Model.Admin;
import com.example.Spring.Ecommerce.Project.Model.ConfirmOrder;

import java.util.List;

public interface AdminService {

    Admin addAdmin(Admin newAdmin);

    List<ConfirmOrder> getLiveOrder();

    CommonResponse updateOrderStatus(Long order_id);

}
