package com.coupon.CouponSpring.services.clients;

import com.coupon.CouponSpring.bean.Company;
import com.coupon.CouponSpring.bean.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {
    boolean login(String email, String password);
    // Company
    void addCompany(Company company) throws CompanyException;
    void updateCompany(int companyId, Company companyToUpdate) throws CompanyException;
    Company geSingleCompany(String email, String password);
    Company geSingleCompany(int companyId) throws CompanyException;
    List<Company> getAllCompanies();
    void deleteCompany(int companyId);

    // Customers
    void addCustomer(Customer customer);
    void updateCustomer(int customerId, Customer customerToUpdate);
    void deleteCustomer(int customerId);
    List<Customer> getAllCustomers();
    Company geSingleCustomer(int customerId) throws CustomerException;
}
