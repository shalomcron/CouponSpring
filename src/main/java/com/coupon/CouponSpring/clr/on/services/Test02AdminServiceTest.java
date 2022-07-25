package com.coupon.CouponSpring.clr.on.services;

import com.coupon.CouponSpring.bean.Company;
import com.coupon.CouponSpring.bean.Customer;
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
        Print.printMainCaption("Start admin service test");
        Print.printMainCaption("Start loginTests");
        loginTests();
        Print.printMainCaption("Start companyTests");
        companyTests();
        Print.printMainCaption("Start customerTests");
        customerTests();
        Print.printMainCaption("End admin service test");
    }

    private void loginTests() {
        try {
            Print.printSubCaption("fail to log-in");
            adminService = (AdminService) loginManager.login("admin1", "admin1", ClientType.Admin);
            Print.printSubCaption(" log-in");
        } catch (Exception e) {
            Print.printException("fail to log-in", e);
        }
        try {
            adminService = (AdminService) loginManager.login("admin", "admin", ClientType.Admin);
            Print.printSubCaption("log-in successfully");
        } catch (Exception e) {
            Print.printException("fail to log-in", e);
        }
    }

    private void companyTests() {
        Print.printSubCaption("Add Company Tests");
        addCompany("TARA");
        addCompany("FOX");
        addCompany("EL-AL");
        addCompany("B-POALIM");
        addCompany("TO-DELETE-5");
        addCompany("TO-UPDATE-6");
        addExistCompany();
        printAllCompanies("after Add companies");
        updateCompanyTests();
        printAllCompanies("after Update companies");
        deleteCompanyTests();
        printAllCompanies("after Delete companies");
        geSingleCompanyTests();
    }

    private void customerTests() {
        Print.printSubCaption("Add Customer Tests");
        addCustomer("Shalom");
        addCustomer("Tossi");
        addCustomer("Nissim");
        addCustomer("Yael");
        addCustomer("TO-DELETE-5");
        addCustomer("TO-UPDATE-6");
        addExistCustomer();
        printAllCustomers("after add customers");
        updateCustomerTest();
        printAllCustomers("after update customers");
        deleteCustomerTest();
        printAllCustomers("after delete customers");
        getCustomersTest();
    }

    private void getCustomersTest() {
        Print.printSubCaption("get customers test");
        try {
            System.out.println(adminService.geSingleCustomer(1));
        } catch (Exception e) {
            Print.printException("get customers", e);
        }
    }

    private void deleteCustomerTest() {
        try {
            int custoerId = 5;
            adminService.deleteCustomer(custoerId);
            Print.printSubCaption("successfully delete customer " + custoerId);
        } catch (Exception e) {
            Print.printException("updating company", e);
        }
    }

    private void updateCustomerTest() {
        try {
            Print.printSubCaption("trying to updating customer id");
            Customer customer = adminService.geSingleCustomer(1);
            adminService.updateCustomer(2, customer);
        } catch (Exception e) {
            Print.printException("updating company", e);
        }
        try {
            int custoerId = 6;
            Customer customer = adminService.geSingleCustomer(custoerId);
            customer.setFirsName("UPDATED FIRST NAME 6");
            adminService.updateCustomer(custoerId, customer);
            Print.printSubCaption("successfully update customer " + customer.getId());
        } catch (Exception e) {
            Print.printException("updating company", e);
        }
    }

    private void printAllCustomers(String desc) {
        Print.printSubCaption(desc + ":");
        adminService.getAllCustomers().forEach(System.out::println);
    }

    private void addCustomer(String name) {
        try {
            adminService.addCustomer(BeanFactoryUtils.getCustomer(name));
            Print.printSubCaption("successfully add customer " + name);
        } catch (Exception e) {
            Print.printException("add customer", e);
        }
    }

    private void addExistCustomer() {
        try {
            Print.printSubCaption("trying to add customer with exists emil");
            Customer customer = adminService.geSingleCustomer(1);
            adminService.addCustomer(customer);
        } catch (Exception e) {
            Print.printException("add customer with exists emil", e);
        }
    }

    private void geSingleCompanyTests() {
        Print.printSubCaption("getting single company");
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
        Print.printSubCaption("deleting exist company");
        adminService.deleteCompany(5);
        Print.printSubCaption("deleting company with id 5 was successfully");
        try {
            Print.printSubCaption("deleting NOT exist company");
            adminService.deleteCompany(555);
        } catch (Exception e) {
            Print.printException("deleting company", e);
        }
    }

    private void updateCompanyTests() {
        try {
            Print.printSubCaption("updating company id");
            Company company = adminService.geSingleCompany(1);
            adminService.updateCompany(2, company);
        } catch (CompanyException e) {
            Print.printException("updating company", e);
        }
        try {
            Print.printSubCaption("updating exists company name");
            Company company = adminService.geSingleCompany(1);
            company.setName("bla");
            adminService.updateCompany(1, company);
        } catch (CompanyException e) {
            Print.printException("updating company", e);
        }
        try {
            Print.printSubCaption("updating exists company email");
            Company company = adminService.geSingleCompany(1);
            company.setName("bla");
            adminService.updateCompany(1, company);
        } catch (CompanyException e) {
            Print.printException("updating company", e);
        }
        try {
            Company company = adminService.geSingleCompany(6);
            company.setPassword("updated_password");
            adminService.updateCompany(6, company);
            Print.printSubCaption("successfully updated company");
        } catch (CompanyException e) {
            Print.printException("updating company", e);
        }
    }

    private void printAllCompanies(String desc) {
        Print.printSubCaption(desc + ":");
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


