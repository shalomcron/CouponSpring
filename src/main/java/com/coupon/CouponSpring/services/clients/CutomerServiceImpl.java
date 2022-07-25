package com.coupon.CouponSpring.services.clients;

import org.springframework.stereotype.Service;

@Service
public class CutomerServiceImpl extends ClientService implements CustomerService {

    @Override
    public boolean login(String email, String password) {
        return customerRepository.existsByEmailAndPassword(email, password);
    }

    @Override
    public void purchaseCoupon(int couponId) {

    }
}
