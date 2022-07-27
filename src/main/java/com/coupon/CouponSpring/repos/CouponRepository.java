package com.coupon.CouponSpring.repos;

import com.coupon.CouponSpring.bean.Company;
import com.coupon.CouponSpring.bean.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CouponRepository extends JpaRepository<Coupon, Integer> {
     boolean existsByTitleAndCompany(String title, Company company);
}
