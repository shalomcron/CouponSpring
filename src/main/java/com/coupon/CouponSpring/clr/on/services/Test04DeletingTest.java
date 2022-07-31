package com.coupon.CouponSpring.clr.on.services;

import com.coupon.CouponSpring.bean.Customer;
import com.coupon.CouponSpring.services.clients.CompanyService;
import com.coupon.CouponSpring.services.clients.CustomerService;
import com.coupon.CouponSpring.services.login.ClientType;
import com.coupon.CouponSpring.services.login.LoginManager;
import com.coupon.CouponSpring.utils.Print;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(4)
public class Test04DeletingTest implements CommandLineRunner {

    @Autowired
    private LoginManager loginManager;
    private CompanyService companyService;

    @Override
    public void run(String... args) {
        Print.printMainCaption("Start Test04DeletingTest");
        Print.printMainCaption("Start company Delete Tests");
        companyDeleteTests();
        Print.printMainCaption("Start delete Coupon Test");
        deleteCouponTest(2);
    }

    private void deleteCouponTest(int couponId) {
        try {
            companyService.deleteCoupon(couponId);
            Print.printSubCaption("company has deleted coupon successfully:" + couponId);
        } catch (Exception e) {
            Print.printException("fail to log-in", e);
        }
    }

    private void companyDeleteTests() {
        try {
            companyService = (CompanyService) loginManager.login("TARA-mail@gmail.com", "TARA-password", ClientType.Company);
            Print.printSubCaption("log-in company successfully");

        } catch (Exception e) {
            Print.printException("fail to log-in", e);
        }
    }

}


