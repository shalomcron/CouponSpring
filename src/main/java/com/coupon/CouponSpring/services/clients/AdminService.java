package com.coupon.CouponSpring.services.clients;

import org.springframework.stereotype.Service;

@Service
public interface AdminService {
    boolean login(String email, String password);
}
