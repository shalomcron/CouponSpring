package com.coupon.CouponSpring.services.clients;

import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
    boolean login(String email, String password);

    void purchaseCoupon(int couponId) throws CouponException;


}
