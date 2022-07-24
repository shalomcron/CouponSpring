package com.coupon.CouponSpring.services.clients;

import org.springframework.stereotype.Service;

@Service
public interface CompanyService {
    boolean login(String email, String password);
}
