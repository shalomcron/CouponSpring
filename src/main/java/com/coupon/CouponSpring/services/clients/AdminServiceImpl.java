package com.coupon.CouponSpring.services.clients;

import com.coupon.CouponSpring.bean.Company;
import com.coupon.CouponSpring.bean.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl extends ClientService implements AdminService {
    @Override
    public boolean login(String email, String password) {
        return email.equals("admin") && password.equals("admin");
    }

    @Override
    public void addCompany(Company company) throws CompanyException {
        if (companyRepository.existsByName(company.getName())) {
            throw new CompanyException(CompanyMsg.COMPANY_NAME_ALREADY_EXIST, company.getName());
        }
        if (companyRepository.existsByEmail(company.getEmail())) {
            throw new CompanyException(CompanyMsg.COMPANY_EMAIL_ALREADY_EXIST, company.getEmail());
        }
        companyRepository.save(company);
    }

    @Override
    public void updateCompany(int companyId, Company companyToUpdate) throws CompanyException {
        if (companyId != companyToUpdate.getId()) {
            throw new CompanyException(CompanyMsg.COMPANY_ID_CANNOT_BE_UPDATED, String.valueOf(companyId));
        }
        Company fromDB = companyRepository.findById(companyId).orElseThrow(() -> new CompanyException(CompanyMsg.COMPANY_NOT_EXIST, String.valueOf(companyId)));
        System.out.println("fromDB" + fromDB);
        if (!fromDB.getName().equals(companyToUpdate.getName())) {
            throw new CompanyException(CompanyMsg.COMPANY_NAME_CANNOT_BE_UPDATED, String.valueOf(companyToUpdate.getName()));
        }

    }

    @Override
    public Company geSingleCompany(String email, String password) {
        return null;
    }

    @Override
    public Company geSingleCompany(int companyId) throws CompanyException {
        return companyRepository.findById(companyId)
                .orElseThrow(() -> new CompanyException(CompanyMsg.COMPANY_NOT_EXIST, String.valueOf(companyId)));
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public void deleteCompany(int companyId) {
        // TODO: delete company coupon
        // TODO: delete customers coupon
        companyRepository.deleteById(companyId);
    }

    @Override
    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void updateCustomer(int customerId, Customer customerToUpdate) {

    }

    @Override
    public void deleteCustomer(int customerId) {

    }

    @Override
    public List<Customer> getAllCustomers() {
        return null;
    }

    @Override
    public Company geSingleCustomer(int customerId) throws CustomerException {
        return null;
    }
}
