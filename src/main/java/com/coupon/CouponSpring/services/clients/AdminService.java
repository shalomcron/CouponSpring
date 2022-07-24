package com.coupon.CouponSpring.services.clients;

import com.coupon.CouponSpring.bean.Company;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {
    boolean login(String email, String password);

    void addCompany(Company company) throws CompanyException;

    void updateCompany(int companyId, Company companyToUpdate) throws CompanyException;

    Company geSingleCompany(String email, String password);

    Company geSingleCompany(int companyId) throws CompanyException;

    List<Company> getAllCompanies();
}
