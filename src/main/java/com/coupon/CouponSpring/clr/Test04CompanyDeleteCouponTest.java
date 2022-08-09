package com.coupon.CouponSpring.clr;

import com.coupon.CouponSpring.services.clients.CompanyService;
import com.coupon.CouponSpring.services.clients.CustomerService;
import com.coupon.CouponSpring.services.login.ClientType;
import com.coupon.CouponSpring.services.login.LoginManager;
import com.coupon.CouponSpring.utils.Print;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

// @Component
@Order(4)
public class Test04CompanyDeleteCouponTest implements CommandLineRunner {
    private CompanyService companyTeva = null;
    private CompanyService companyFox = null;

    @Autowired
    private LoginManager loginManager;

    @Override
    public void run(String... args) throws Exception {
        Print.printMainCaption("Start Company Delete Coupon Test -" +
                "(Will delete purchased coupons from customers_vs_coupons table)");
        companyTeva = Test02CompanyServiceTest.getCompanyTeva();
        companyFox = Test02CompanyServiceTest.getCompanyFox();

        Print.printMainCaption("Start delete Coupon Test");
        deleteCouponTest(companyTeva, 1);
        deleteCouponTest(companyFox, 3);
        Print.printMainCaption("End Company Delete Coupon Test");
    }

    private void deleteCouponTest(CompanyService company, int couponId) {
        try {
            String name = company.getCompanyDetails().getName();
            company.deleteCoupon(couponId);
            Print.printSubCaption(name + "  deleted coupon successfully, couponId:" + couponId);
        } catch (Exception e) {
            Print.printException("EX IN deleteCouponTest", e);
        }
    }
}


