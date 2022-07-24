package com.coupon.CouponSpring.services.clients;

import com.coupon.CouponSpring.bean.Company;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
}
