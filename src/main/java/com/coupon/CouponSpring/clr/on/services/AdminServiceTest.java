package com.coupon.CouponSpring.clr.on.services;

import com.coupon.CouponSpring.services.clients.AdminService;
import com.coupon.CouponSpring.services.login.LoginManager;
import com.coupon.CouponSpring.utils.Print;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AdminServiceTest implements CommandLineRunner {

    @Autowired
    private LoginManager loginManager;

    @Override
    public void run(String... args) throws Exception {
        Print.printCaption("Start admin service test");
        Print.printSubCaption(" get service instance from login manager ");
    }
}
