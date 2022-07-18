package com.coupon.CouponSpring.services.clients;

import com.coupon.CouponSpring.repos.CompanyRepository;
import com.coupon.CouponSpring.repos.CouponRepository;
import com.coupon.CouponSpring.repos.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class ClientService {
    @Autowired
    protected CompanyRepository companyRepository;
    @Autowired
    protected CustomerRepository customerRepository;
    @Autowired
    protected CouponRepository couponRepository;
    
}
