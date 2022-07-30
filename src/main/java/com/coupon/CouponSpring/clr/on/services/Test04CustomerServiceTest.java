package com.coupon.CouponSpring.clr.on.services;

import com.coupon.CouponSpring.services.clients.CustomerService;
import com.coupon.CouponSpring.services.login.ClientType;
import com.coupon.CouponSpring.services.login.LoginManager;
import com.coupon.CouponSpring.utils.Print;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class Test04CustomerServiceTest implements CommandLineRunner {
    CustomerService customerService = null;

    @Autowired
    private LoginManager loginManager;

    @Override
    public void run(String... args) {
        Print.printMainCaption("Start Customer test");
        Print.printMainCaption("Start Customer login Tests");
        loginTests();
        Print.printMainCaption("Start purchase Coupon Test");
        purchaseCouponTest(1);
    }

    private void purchaseCouponTest(int couponId) {
        try {
            customerService.purchaseCoupon(couponId);
            Print.printSubCaption("purchase coupon ended successfully, couponId:" + couponId);
        } catch (Exception e) {
            Print.printException("fail to purchase coupon", e);
        }
    }

    private void loginTests() {
        try {
            Print.printSubCaption("trying to log-in Customer");
            customerService = (CustomerService) loginManager.login("bla", "bla", ClientType.Customer);
        } catch (Exception e) {
            Print.printException("fail to log-in", e);
        }
        try {
            customerService = (CustomerService) loginManager.login("Shalom-mail@gmail.com", "Shalom-password", ClientType.Customer);
            Print.printSubCaption("log-in Customer successfully");
        } catch (Exception e) {
            Print.printException("fail to log-in", e);
        }
    }

}


