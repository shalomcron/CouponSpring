package com.coupon.CouponSpring.clr;

import com.coupon.CouponSpring.bean.Company;
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
public class Test02CompanyServiceTest implements CommandLineRunner {
    private CompanyService companyTeva = null;
    private CompanyService companyFox = null;

    @Autowired
    private LoginManager loginManager;

    @Override
    public void run(String... args) {
        Print.printMainCaption("Start Company Service Test");
        loginTests();
    }

    private void loginTests() {
        try {
            companyTeva = (CompanyService) loginManager.login("admin1", "admin1", ClientType.Company);
            Print.printSubCaption("companyTeva logged in successfully");
        } catch (Exception e) {
            Print.printException("company Teva fail to log-in", e);
        }
        try {
            companyFox = (CompanyService) loginManager.login("admin", "admin", ClientType.Company);
            Print.printSubCaption("companyFox logged in successfully");
        } catch (Exception e) {
            Print.printException("company Fox fail to log-in", e);
        }
    }

}


