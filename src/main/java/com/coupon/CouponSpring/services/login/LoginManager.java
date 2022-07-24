package com.coupon.CouponSpring.services.login;

import com.coupon.CouponSpring.services.clients.*;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginManager {

    @Autowired
    private ApplicationContext ctx;

    public ClientService login(String email, String password, ClientType clientType) throws LoginException {
        ClientService res = null;
        switch (clientType) {
            case Admin:
                res = (ClientService) ctx.getBean(AdminService.class);
                break;
            case Company:
                res = (ClientService) ctx.getBean(CompanyService.class);
                break;
            case Customer:
                res = (ClientService) ctx.getBean(CustomerService.class);
                break;
        }
        if (res != null && !res.login(email, password)) {
            throw new LoginException(clientType);
        }
        return res;
    }
}
