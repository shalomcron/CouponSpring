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

        Print.printCaption("Add Company Tests");
        addCompany("TARA");
        addCompany("FOX");
        addCompany( "EL-AL");
        addCompany( "B-POALIM");
        addCompany( "TO-DELETE-5");
        addExistCompany();
        printAllCompanies("after add companies");

        Print.printCaption("Update Company Tests");
        updateCompanyTests();
        printAllCompanies("after Update companies");

        Print.printCaption("Delete Company Tests");
        deleteCompanyTests();
        printAllCompanies("after Delete companies");

        geSingleCompanyTests();

        Print.printCaption("End admin service test");
    }

    private void geSingleCompanyTests() {
        Print.printCaption("getting single company");
        try {
            System.out.println(adminService.geSingleCompany(1));
        } catch (Exception e) {
            Print.printException("getting single company", e);
        }
        try {
            System.out.println(adminService.geSingleCompany(5555));
        } catch (Exception e) {
            Print.printException("getting single company", e);
        }
    }

    private void deleteCompanyTests() {
        Print.printCaption("deleting exist company");
        adminService.deleteCompany(5);
        Print.printCaption("deleting company with id 5 was successfully");

        try {
            Print.printCaption("deleting NOT exist company");
            adminService.deleteCompany(555);
        } catch (Exception e) {
            Print.printException("deleting company", e);
        }
    }

    private void updateCompanyTests() {
        try {
            Print.printCaption("updating company id");
            Company company = adminService.geSingleCompany(1);
            adminService.updateCompany(2, company);
        } catch (CompanyException e) {
            Print.printException("updating company", e);
        }
        try {
            Print.printCaption("updating company name");
            Company company = adminService.geSingleCompany(1);
            company.setName("bla");
            adminService.updateCompany(1, company);
        } catch (CompanyException e) {
            Print.printException("updating company", e);
        }
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


