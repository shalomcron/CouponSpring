package com.coupon.CouponSpring.session;

import com.coupon.CouponSpring.services.clients.CompanyService;
import com.coupon.CouponSpring.services.clients.CustomerException;
import com.coupon.CouponSpring.services.clients.CustomerMsg;
import com.coupon.CouponSpring.services.clients.CustomerService;
import com.coupon.CouponSpring.services.login.ClientType;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class CouponSession {
    HashMap<String, CustomerService> sessions = new HashMap<>();

    public void setCustomer(int id, CustomerService customerService) {
        sessions.put(ClientType.Customer.name() + "-" + id, customerService);
    }

    public CustomerService getCustomerSession(int id) throws CustomerException {
        CustomerService customerService = sessions.get(ClientType.Customer.name() + "-" + id);
        if (customerService == null) {
            throw new CustomerException(CustomerMsg.CUSTOMER_IS_SESSION_NOT_FOUND, String.valueOf(id));
        }
        return customerService;
    }

    public void setCompanySession(int id, CompanyService companyService) {
    }
}
