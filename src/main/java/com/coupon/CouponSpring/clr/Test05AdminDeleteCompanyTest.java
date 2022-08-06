package com.coupon.CouponSpring.clr;

import com.coupon.CouponSpring.services.clients.AdminService;
import com.coupon.CouponSpring.services.clients.CompanyService;
import com.coupon.CouponSpring.services.login.LoginManager;
import com.coupon.CouponSpring.utils.Print;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

// @Component
@Order(4)
public class Test05AdminDeleteCompanyTest implements CommandLineRunner {
    private CompanyService companyTeva = null;
    private CompanyService companyFox = null;
    private AdminService adminService = null;

    @Autowired
    private LoginManager loginManager;

    @Override
    public void run(String... args) throws Exception {
        Print.printMainCaption("Start Admin Delete Company Test -"
                + "(Will delete purchased coupons from customers_vs_coupons table)"
        );
        adminService = Test01AdminServiceTest.getAdminService();
        companyTeva = Test02CompanyServiceTest.getCompanyTeva();
        companyFox = Test02CompanyServiceTest.getCompanyFox();

        Print.printMainCaption("Start delete Companies Test");
        deleteCompanyTest(companyTeva);
        deleteCompanyTest(companyFox);
        Print.printMainCaption("Start Admin Delete Company Test");
    }

    private void deleteCompanyTest(CompanyService companyTeva) {
        adminService.deleteCompany(companyTeva.getCompanyDetails().getId());
        Print.printSubCaption("admin has deleted company " + companyTeva.getCompanyDetails().getName() + " successfully");
    }

}


