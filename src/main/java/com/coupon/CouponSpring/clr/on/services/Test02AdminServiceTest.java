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

    @Autowired
    private LoginManager loginManager;

    @Override
    public void run(String... args) {
        Print.printCaption("Start admin service test");
        Print.printSubCaption("get Admin object from login manager");
        AdminService adminService = (AdminService) loginManager.login("admin", "admin", ClientType.Admin);

        if (adminService != null) {
            Print.printSubCaption("adminService != null");
            try {
                Print.printSubCaption("company not exist on DB");
                Company taraCompany = adminService.geSingleCompany(33);
            } catch (CompanyException e) {
                e.printStackTrace();
            }

            try {
                Print.printSubCaption("cannot add company with exist name");
                Company taraCompany = adminService.geSingleCompany(1);
                taraCompany.setEmail("xxx");
                adminService.addCompany(taraCompany);
            } catch (CompanyException e) {
                e.printStackTrace();
            }

            Print.printSubCaption("cannot add company with exist email");
            try {
                Company taraCompany = adminService.geSingleCompany(1);
                taraCompany.setName("xxx");
                adminService.addCompany(taraCompany);
            } catch (CompanyException e) {
                e.printStackTrace();
            }

            Print.printSubCaption("add company OK");
            try {
                Company taraCompany = adminService.geSingleCompany(1);
                taraCompany.setName("updated_name");
                taraCompany.setEmail("updated_email");
                taraCompany.setId(0);
                adminService.addCompany(taraCompany);
            } catch (CompanyException e) {
                e.printStackTrace();
            }

            adminService.g

            Print.printSubCaption("update company");
//            try {
//
//            } catch (CompanyException e) {
//                e.printStackTrace();
//            }
//            try {
//                adminService.updateCompany(1, taraCompany);
//            } catch (Exception e) {
//                Print.printException("When updating company", e);
//            }
        }
        Print.printCaption("End admin service test");
    }
}


/**
 * public void updateCompany(int id, Company companyToUpdate) throws JDBCException, CompanyException {
 * Company companyDromDB = companyDAO.getSingle(id);
 * if (companyDromDB == null) {
 * throw new CompanyException(CompanyMsg.COMPANY_NOT_EXIST);
 * }
 * if (!companyDromDB.getName().equals(companyToUpdate.getName())) {
 * throw new CompanyException(CompanyMsg.COMPANY_NAME_CANNOT_BE_UPDATED);
 * }
 * if (id != companyToUpdate.getId()) {
 * throw new CompanyException(CompanyMsg.COMPANY_ID_CANNOT_BE_UPDATED);
 * }
 * companyDAO.update(id, companyToUpdate);
 * }
 * <p>
 * public Company geSingleCompany(String email, String password) throws JDBCException {
 * return companyDAO.getSingle(email, password);
 * }
 * <p>
 * public Customer geSingleCustomer(String email, String password) throws JDBCException {
 * return customerDAO.getSingle(email, password);
 * }
 * <p>
 * public void deleteCompany(int id) throws JDBCException {
 * // TODO: delete company coupon
 * // TODO: delete customers coupon
 * companyDAO.delete(id);
 * }
 * <p>
 * public List<Company> getAllCompanies() throws JDBCException {
 * return companyDAO.getAll();
 * }
 * <p>
 * public Company getOneCompany(int id) throws JDBCException {
 * return companyDAO.getSingle(id);
 * }
 * <p>
 * public void addCustomer(Customer customer) throws JDBCException, CustomerException {
 * if (customerDAO.isExistByEmail(customer.getEmail())) {
 * throw new CustomerException(CustomerMsg.CUSTOMER_EMAIL_EXIST);
 * }
 * customerDAO.add(customer);
 * }
 * <p>
 * public void updateCustomer(int id, Customer customerToUpdate) throws JDBCException, CustomerException {
 * Customer customerFromDB = customerDAO.getSingle(id);
 * if (customerFromDB.getId() != customerToUpdate.getId()) {
 * throw new CustomerException(CustomerMsg.CUSTOMER_ID_ALREADY_EXIST);
 * }
 * customerDAO.update(id, customerToUpdate);
 * }
 * <p>
 * public void deleteCustomer(Customer customer) throws JDBCException {
 * // TODO: DELETE CUSTOMER COUPONS
 * customerDAO.delete(customer.getId());
 * }
 * <p>
 * public List<Customer> getAllCustomers() throws JDBCException {
 * return customerDAO.getAll();
 * }
 * <p>
 * public Customer geSingleCompany(int id) throws JDBCException {
 * return customerDAO.getSingle(id);
 * }
 * <p>
 * }
 */