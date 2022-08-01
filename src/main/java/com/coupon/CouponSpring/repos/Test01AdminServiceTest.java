package com.coupon.CouponSpring.repos;

import com.coupon.CouponSpring.bean.Company;
import com.coupon.CouponSpring.bean.Customer;
import com.coupon.CouponSpring.services.clients.AdminService;
import com.coupon.CouponSpring.services.clients.CompanyException;
import com.coupon.CouponSpring.services.login.ClientType;
import com.coupon.CouponSpring.services.login.LoginManager;
import com.coupon.CouponSpring.utils.BeanFactoryUtils;
import com.coupon.CouponSpring.utils.Print;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class Test01AdminServiceTest implements CommandLineRunner {
    AdminService adminService = null;

    @Autowired
    private LoginManager loginManager;

    @Override
    public void run(String... args) {
        Print.printMainCaption("Start admin service test");
        Print.printMainCaption("Start loginTests");
        loginTests();
    }

    private void loginTests() {
        try {
            Print.printSubCaption("fail to log-in");
            adminService = (AdminService) loginManager.login("admin1", "admin1", ClientType.Admin);
            Print.printSubCaption("admin logged in successfully");
        } catch (Exception e) {
            Print.printException("fail admin to log-in", e);
        }
        try {
            adminService = (AdminService) loginManager.login("admin", "admin", ClientType.Admin);
            Print.printSubCaption("admin logged in successfully");
        } catch (Exception e) {
            Print.printException("fail admin to log-in", e);
        }
    }

}


