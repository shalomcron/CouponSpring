package com.coupon.CouponSpring.clr.on.services;

import com.coupon.CouponSpring.services.clients.AdminService;
import com.coupon.CouponSpring.services.clients.CompanyService;
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
    private AdminService adminService;

    @Override
    public void run(String... args) {
        Print.printMainCaption("Start Test04DeletingTest");
        Print.printMainCaption("Start admin log-in");
        adminLogin();
        adminDeleteCompanyTest(1);
//        Print.printMainCaption("Start company log-in");
//        companyLogin();
//        Print.printMainCaption("Start company Delete Coupon Test");
//        companyDeleteCouponTest(2);
    }

    private void adminDeleteCompanyTest(int companyId) {
        adminService.deleteCompany(companyId);
        Print.printSubCaption("admin deleted company:" + companyId);
    }


    private void adminLogin() {
        try {
            adminService = (AdminService) loginManager.login("admin", "admin", ClientType.Admin);
            Print.printSubCaption("admin log-in successfully");
        } catch (Exception e) {
            Print.printException("admin fail to log-in", e);
        }
    }

    private void companyDeleteCouponTest(int couponId) {
        try {
            companyService.deleteCoupon(couponId);
            Print.printSubCaption("company has deleted coupon successfully:" + couponId);
        } catch (Exception e) {
            Print.printException("company fail to log-in", e);
        }
    }

    private void companyLogin() {
        try {
            companyService = (CompanyService) loginManager.login("TARA-mail@gmail.com", "TARA-password", ClientType.Company);
            Print.printSubCaption("log-in company successfully");

        } catch (Exception e) {
            Print.printException("fail to log-in", e);
        }
    }

}


