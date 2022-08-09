package com.coupon.CouponSpring.session;

import com.coupon.CouponSpring.services.clients.*;
import com.coupon.CouponSpring.services.login.ClientType;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class ClientsSession {
    HashMap<String, ClientService> sessions = new HashMap<>();

    public void setCustomer(int id, CustomerService customerService) {
        sessions.put(ClientType.Customer.name() + "-" + id, (ClientService) customerService);
    }

    public CustomerService getCustomerSession(int id) throws CustomerException {
        CustomerService customerService = (CustomerService) sessions.get(ClientType.Customer.name() + "-" + id);
        if (customerService == null) {
            throw new CustomerException(CustomerMsg.CUSTOMER_SESSION_NOT_FOUND, String.valueOf(id));
        }
        return customerService;
    }

    public void setCompanySession(int id, CompanyService companyService) {
        sessions.put(ClientType.Company.name() + "-" + id, (ClientService) companyService);
    }

    public CompanyService getCompanySession(int id) throws CompanyException {
        CompanyService companyService = (CompanyService) sessions.get(ClientType.Company.name() + "-" + id);
        if (companyService == null) {
            throw new CompanyException(CompanyMsg.COMPANY_SESSION_NOT_FOUND, String.valueOf(id));
        }
        return companyService;
    }
}
