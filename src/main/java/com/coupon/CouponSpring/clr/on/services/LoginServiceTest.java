package com.coupon.CouponSpring.clr.on.services;

import com.coupon.CouponSpring.services.clients.AdminService;
import com.coupon.CouponSpring.services.clients.CompanyService;
import com.coupon.CouponSpring.services.clients.CustomerService;
import com.coupon.CouponSpring.utils.Print;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

// @Component
public class LoginServiceTest implements CommandLineRunner {
    @Autowired
    private AdminService adminService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private CustomerService customerService;

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
        boolean isLogin4 = companyService.login("FOX-mail@gmail.com", "FOX-password");
        System.out.println("isLogin3:" + isLogin3);
        System.out.println("isLogin4:" + isLogin4);

        Print.printSubCaption("Customer login");
        boolean isLogin5 = customerService.login("", "");
        boolean isLogin6 = customerService.login("Yuval-mail@gmail.com", "Yuval-password");
        System.out.println("isLogin5:" + isLogin5);
        System.out.println("isLogin6:" + isLogin6);

        Print.printCaption("End customer service test");
    }
}
