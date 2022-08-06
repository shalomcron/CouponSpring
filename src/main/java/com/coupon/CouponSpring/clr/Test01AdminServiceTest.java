package com.coupon.CouponSpring.clr;

import com.coupon.CouponSpring.bean.Company;
import com.coupon.CouponSpring.services.clients.AdminService;
import com.coupon.CouponSpring.services.clients.CompanyException;
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
public class Test01AdminServiceTest implements CommandLineRunner {

    private static AdminService adminService = null;

    @Autowired
    private LoginManager loginManager;

    @Override
    public void run(String... args) {
        Print.printMainCaption("Start admin service test");
        loginTests();
        Print.printMainCaption("Start add Companies Test");
        addCompaniesTest();
        Print.printMainCaption("Start add Customers Test");
        addCustomersTest();
        Print.printMainCaption("END admin service test");
    }

    private void addCustomersTest() {
        addCustomer("Customer-1");
        addCustomer("Customer-2");
    }

    private void addCompaniesTest() {
        Company fox = BeanFactoryUtils.getCompany("FOX");
        try {
            adminService.addCompany(fox);
            Print.printSubCaption("successfully add company " + fox.getName());
        } catch (CompanyException e) {
            Print.printException("adding company " + fox.getName(), e);
        }

        Company teva = BeanFactoryUtils.getCompany("TEVA");
        try {
            adminService.addCompany(teva);
            Print.printSubCaption("successfully add company " + teva.getName());
        } catch (CompanyException e) {
            Print.printException("adding company " + teva.getName(), e);
        }
    }

    private void loginTests() {
        try {
            adminService = (AdminService) loginManager.login("admin1", "admin1", ClientType.Admin);
            Print.printSubCaption("admin logged in successfully");
        } catch (Exception e) {
            Print.printException("fail admin to log-in", e);
        }
        try {
            adminService = (AdminService) loginManager.login("admin", "admin", ClientType.Admin);
            Print.printSubCaption("admin logged in successfully");
        } catch (Exception e) {
            Print.printException("fail admin to log-in", e);
        }
    }


    private void addCustomer(String name) {
        try {
            adminService.addCustomer(BeanFactoryUtils.getCustomer(name));
            Print.printSubCaption("successfully add customer " + name);
        } catch (Exception e) {
            Print.printException("add customer", e);
        }
    }

    public static AdminService getAdminService() {
        return adminService;
    }
}



