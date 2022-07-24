package com.coupon.CouponSpring.services.login;

import com.coupon.CouponSpring.services.clients.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginManager {

    @Autowired
    private AdminService adminService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private CustomerService customerService;

    public ClientService login(String email, String password, ClientType clientType) {
        ClientService res = null;
        try {
            switch (clientType) {
                case Admin:
                    res = (ClientService) adminService;
                    break;
                case Company:
                    res = (ClientService) companyService;
                    break;
                case Customer:
                    res = (ClientService) customerService;
                    break;
            }
            if (res != null && !res.login(email, password)) {
                throw new LoginException(clientType);
            }
        } catch (LoginException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return res;
    }
}
