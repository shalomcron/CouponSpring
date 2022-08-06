package com.coupon.CouponSpring.session;

import com.coupon.CouponSpring.services.clients.CustomerService;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class CouponSession {
    HashMap<Integer, CustomerService> sessions = new HashMap<>();

    public void setCustomer(int id, CustomerService customerService) {
        sessions.put(id, customerService);
    }

    public CustomerService getCustomer(int id) {
        return sessions.get(id);
    }
}
