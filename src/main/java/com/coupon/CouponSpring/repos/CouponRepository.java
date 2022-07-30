package com.coupon.CouponSpring.repos;

import com.coupon.CouponSpring.bean.Category;
import com.coupon.CouponSpring.bean.Company;
import com.coupon.CouponSpring.bean.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CouponRepository extends JpaRepository<Coupon, Integer> {
     boolean existsByTitleAndCompany(String title, Company company);

    Coupon findByIdAndCompany(int couponId, Company company);

    List<Coupon> findByCompany(Company company);

    List<Coupon> findByCompanyAndCategory(Company company, Category category);

    @Query(
            nativeQuery = true,
            value = "select * from coupons where company=?1 and price<?2"
    )
    // TODO: fix sql
    List<Coupon> findByCompanyAndMaxPrice(int companyId, double maxPrice);
}
