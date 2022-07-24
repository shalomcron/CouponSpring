package com.coupon.CouponSpring.clr.on.services;

import com.coupon.CouponSpring.bean.Category;
import com.coupon.CouponSpring.bean.Company;
import com.coupon.CouponSpring.bean.Coupon;
import com.coupon.CouponSpring.services.clients.AdminService;
import com.coupon.CouponSpring.services.login.ClientType;
import com.coupon.CouponSpring.services.login.LoginManager;
import com.coupon.CouponSpring.utils.BeanFactoryUtils;
import com.coupon.CouponSpring.utils.Print;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class Test01AdminServiceTest implements CommandLineRunner {

    @Autowired
    private LoginManager loginManager;

    @Override
    public void run(String... args) throws Exception {
        Print.printCaption("Start admin service test");
        Print.printSubCaption("get Admin object from login manager");
        AdminService adminService = (AdminService) loginManager.login("admin", "admin", ClientType.Admin);

        if (adminService != null) {
            Print.printSubCaption("adminService != null");
            Print.printSubCaption("add companies");
            // tara
            String taraCompanyName = "TARA";
            Company taraCompany = BeanFactoryUtils.getCompany(taraCompanyName);
            adminService.addCompany(taraCompany);

            // fox
            String foxCompanyName = "FOX";
            Company foxCompany = BeanFactoryUtils.getCompany(foxCompanyName);
            adminService.addCompany(foxCompany);
        }
        Print.printCaption("End admin service test");
    }
}


/**

public void updateCompany(int id, Company companyToUpdate) throws JDBCException, CompanyException {
Company companyDromDB = companyDAO.getSingle(id);
if (companyDromDB == null) {
throw new CompanyException(CompanyMsg.COMPANY_NOT_EXIST);
}
if (!companyDromDB.getName().equals(companyToUpdate.getName())) {
throw new CompanyException(CompanyMsg.COMPANY_NAME_CANNOT_BE_UPDATED);
}
if (id != companyToUpdate.getId()) {
throw new CompanyException(CompanyMsg.COMPANY_ID_CANNOT_BE_UPDATED);
}
companyDAO.update(id, companyToUpdate);
}

public Company geSingleCompany(String email, String password) throws JDBCException {
return companyDAO.getSingle(email, password);
}

public Customer geSingleCustomer(String email, String password) throws JDBCException {
return customerDAO.getSingle(email, password);
}

public void deleteCompany(int id) throws JDBCException {
// TODO: delete company coupon
// TODO: delete customers coupon
companyDAO.delete(id);
}

public List<Company> getAllCompanies() throws JDBCException {
return companyDAO.getAll();
}

public Company getOneCompany(int id) throws JDBCException {
return companyDAO.getSingle(id);
}

public void addCustomer(Customer customer) throws JDBCException, CustomerException {
if (customerDAO.isExistByEmail(customer.getEmail())) {
throw new CustomerException(CustomerMsg.CUSTOMER_EMAIL_EXIST);
}
customerDAO.add(customer);
}

public void updateCustomer(int id, Customer customerToUpdate) throws JDBCException, CustomerException {
Customer customerFromDB = customerDAO.getSingle(id);
if (customerFromDB.getId() != customerToUpdate.getId()) {
throw new CustomerException(CustomerMsg.CUSTOMER_ID_ALREADY_EXIST);
}
customerDAO.update(id, customerToUpdate);
}

public void deleteCustomer(Customer customer) throws JDBCException {
// TODO: DELETE CUSTOMER COUPONS
customerDAO.delete(customer.getId());
}

public List<Customer> getAllCustomers() throws JDBCException {
return customerDAO.getAll();
}

public Customer geSingleCompany(int id) throws JDBCException {
return customerDAO.getSingle(id);
}

}
 *
 */