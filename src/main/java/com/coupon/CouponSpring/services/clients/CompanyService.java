package com.coupon.CouponSpring.services.clients;

import com.coupon.CouponSpring.bean.Category;
import com.coupon.CouponSpring.bean.Company;
import com.coupon.CouponSpring.bean.Coupon;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompanyService {
    boolean login(String email, String password);

    void addCoupon(Coupon coupon) throws CouponException;

    Coupon getSingleCoupon(int couponId);

    void updateCoupon(int couponId, Coupon couponToUpdate) throws CouponException;

    void deleteCoupon(int couponId);

    List<Coupon> getAllCoupons();

    List<Coupon> getAllCoupons(Category category);

    List<Coupon> getAllCoupons(double maxPrice);

    Company getCompanyDetails();

}
