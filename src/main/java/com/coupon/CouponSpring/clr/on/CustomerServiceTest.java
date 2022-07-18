package com.coupon.CouponSpring.clr.on;

import com.coupon.CouponSpring.services.clients.AdminService;
import com.coupon.CouponSpring.services.clients.CompanyService;
import com.coupon.CouponSpring.utils.Print;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class CustomerServiceTest implements CommandLineRunner {
    @Autowired
    AdminService adminService;
    @Autowired
    CompanyService companyService;

    @Override
    public void run(String... args) {
        Print.printCaption("Start customer service test");
        Print.printSubCaption("Admin login");
        boolean isLogin1 = adminService.login("", "");
        boolean isLogin2 = adminService.login("admin", "admin");
        System.out.println("isLogin1:" + isLogin1);
        System.out.println("isLogin2:" + isLogin2);

        Print.printSubCaption("Company login");
        boolean isLogin3 = companyService.login("", "");
        boolean isLogin4 = companyService.login("admin", "admin");
        System.out.println("isLogin3:" + isLogin3);
        System.out.println("isLogin4:" + isLogin4);

        Print.printCaption("End customer service test");
    }
}
