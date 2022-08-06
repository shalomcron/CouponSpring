package com.coupon.CouponSpring.session;

import com.coupon.CouponSpring.services.clients.CustomerException;
import com.coupon.CouponSpring.services.clients.CustomerMsg;
import com.coupon.CouponSpring.services.clients.CustomerService;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class CouponSession {
    HashMap<Integer, CustomerService> sessions = new HashMap<>();

    public void setCustomer(int id, CustomerService customerService) {
        sessions.put(id, customerService);
    }

    public CustomerService getCustomer(int id) throws CustomerException {
        CustomerService customerService = sessions.get(id);
        if (customerService == null) {
            throw new CustomerException(CustomerMsg.CUSTOMER_IS_SESSION_NOT_FOUND, String.valueOf(id));
        }
        return sessions.get(id);
    }
}
