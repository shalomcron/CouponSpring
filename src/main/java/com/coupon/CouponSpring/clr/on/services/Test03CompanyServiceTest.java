package com.coupon.CouponSpring.clr.on.services;

import com.coupon.CouponSpring.bean.Company;
import com.coupon.CouponSpring.bean.Customer;
import com.coupon.CouponSpring.services.clients.AdminService;
import com.coupon.CouponSpring.services.clients.CompanyException;
import com.coupon.CouponSpring.services.clients.CompanyService;
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
public class Test03CompanyServiceTest implements CommandLineRunner {
    CompanyService companyService = null;

    @Autowired
    private LoginManager loginManager;

    @Override
    public void run(String... args) {
        Print.printMainCaption("Start company test");
        Print.printMainCaption("Start company login Tests");
        loginTests();

    }

    private void loginTests() {
        try {
            Print.printSubCaption("trying to log-in company");
            companyService = (CompanyService) loginManager.login("bla", "bla", ClientType.Company);
        } catch (Exception e) {
            Print.printException("fail to log-in", e);
        }
        try {
            companyService = (CompanyService) loginManager.login("TARA-mail@gmail.com", "TARA-password", ClientType.Company);
            Print.printSubCaption("log-in company successfully");
        } catch (Exception e) {
            Print.printException("fail to log-in", e);
        }
    }
}


