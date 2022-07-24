package com.coupon.CouponSpring.services.clients;

import com.coupon.CouponSpring.bean.Company;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {
    boolean login(String email, String password);

    void addCompany(Company company) throws CompanyException;

    void updateCompany(int id, Company companyToUpdate);

    Company geSingleCompany(String email, String password);

}
