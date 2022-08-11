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
    Company getCompany(int companyId) throws CompanyException;

    // Customers
    void addCustomer(Customer customer) throws CustomerException;
    void updateCustomer(int customerId, Customer customerToUpdate) throws CustomerException;
    void deleteCustomer(int customerId);
    List<Customer> getAllCustomers();
    Customer geSingleCustomer(int customerId) throws CustomerException;
}
