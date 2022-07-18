package com.coupon.CouponSpring.services.clients;

import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl extends ClientService implements CompanyService {

    @Override
    public boolean login(String email, String password) {
        // TODO: CHECK IN DB
        return false;
    }
}
