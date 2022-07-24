package com.coupon.CouponSpring.clr.on.services;

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
public class Test02AdminServiceTest implements CommandLineRunner {
    AdminService adminService = null;

    @Autowired
    private LoginManager loginManager;

    @Override
    public void run(String... args) {
        Print.printCaption("Start admin service test");

        Print.printSubCaption("fail to log-in");
        try {
            adminService = (AdminService) loginManager.login("admin", "admin", ClientType.Admin);
        } catch (Exception e) {
            Print.printException("log-in", e);
        }

        try {
            adminService = (AdminService) loginManager.login("admin1", "admin1", ClientType.Admin);
        } catch (Exception e) {
            Print.printException("fail to log-in", e);
        }
        try {
            adminService = (AdminService) loginManager.login("admin", "admin", ClientType.Admin);
            Print.printSubCaption("log-in successfullyfully");
        } catch (Exception e) {
            Print.printException("fail to log-in", e);
        }
        System.out.println("adminService:" + adminService);
        addCompany("TARA");
        addCompany("FOX");
        addCompany( "EL-AL");
        addCompany( "B-POALIM");
        addExistCompany();
        printAllCompanies("after add connies");


        Print.printCaption("End admin service test");
    }

    private void printAllCompanies(String desc) {
        Print.printCaption(desc + ":");
        adminService.getAllCompanies().forEach(System.out::println);
    }

    private void addExistCompany() {
        try {
            Company company = adminService.geSingleCompany(1);
            company.setEmail("bla");
            adminService.addCompany(company);
        } catch (CompanyException e) {
            Print.printException("add company with exists name", e);
        }
        try {
            Company company = adminService.geSingleCompany(1);
            company.setName("bla");
            adminService.addCompany(company);
        } catch (CompanyException e) {
            Print.printException("add company with exists email", e);
        }
    }

    private void addCompany(String name) {
        try {
            adminService.addCompany(BeanFactoryUtils.getCompany(name));
            Print.printSubCaption("successfully add company " + name);
        } catch (CompanyException e) {
            Print.printException("adding company", e);
        }
    }
}


