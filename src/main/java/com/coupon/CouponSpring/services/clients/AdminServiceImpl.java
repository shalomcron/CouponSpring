package com.coupon.CouponSpring.services.clients;

import com.coupon.CouponSpring.bean.Company;
import org.springframework.stereotype.Service;

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
        if (companyRepository.existsByEmail(company.getName())) {
            throw new CompanyException(CompanyMsg.COMPANY_EMAIL_ALREADY_EXIST, company.getEmail());
        }
        companyRepository.save(company);
    }

    @Override
    public void updateCompany(int id, Company companyToUpdate) {

    }

    @Override
    public Company geSingleCompany(String email, String password) {
        return null;
    }
}
