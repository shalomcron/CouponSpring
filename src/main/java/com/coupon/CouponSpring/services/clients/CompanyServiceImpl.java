package com.coupon.CouponSpring.services.clients;

import com.coupon.CouponSpring.bean.Category;
import com.coupon.CouponSpring.bean.Company;
import com.coupon.CouponSpring.bean.Coupon;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl extends ClientService implements CompanyService {

    private int companyId;

    @Override
    public boolean login(String email, String password) {
        try {
            Company company = companyRepository.findByEmailAndPassword(email, password)
                    .orElseThrow();
            this.companyId = company.getId();
            return true;
        } catch (Exception e) {
            System.out.println("E"+e.getMessage());
            return false;
        }
    }

    @Override
    public void addCoupon(Coupon coupon) {

    }

    @Override
    public void updateCoupon(int couponId, Coupon couponToUpdate) {

    }

    @Override
    public void deleteCoupon(int couponId) {

    }

    @Override
    public List<Coupon> getAllCoupons() {
        return null;
    }

    @Override
    public List<Coupon> getAllCoupons(Category category) {
        return null;
    }

    @Override
    public List<Coupon> getAllCoupons(double maxPrice) {
        return null;
    }

    @Override
    public Company getCompanyDetails() {
        return null;
    }
}
