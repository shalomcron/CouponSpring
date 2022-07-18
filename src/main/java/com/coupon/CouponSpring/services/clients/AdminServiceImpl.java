package com.coupon.CouponSpring.services.clients;

import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl extends ClientService implements AdminService {
    @Override
    public boolean login(String email, String password) {
        return email.equals("admin") && password.equals("admin");
    }
}
