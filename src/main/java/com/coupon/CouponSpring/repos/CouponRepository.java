package com.coupon.CouponSpring.repos;

import com.coupon.CouponSpring.bean.Category;
import com.coupon.CouponSpring.bean.Company;
import com.coupon.CouponSpring.bean.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;


public interface CouponRepository extends JpaRepository<Coupon, Integer> {
    boolean existsByTitleAndCompany(String title, Company company);


    @Modifying
    @Transactional
    @Query(
            value = "UPDATE `coupons-using-spring`.`coupons` SET `amount` = `amount` -1 WHERE (`id` = ?1);",
            nativeQuery = true
    )
    void decreaseAmount(int couponId);
}

/**

 Coupon findByIdAndCompany(int couponId, Company company);

 List<Coupon> findByCompany(Company company);

 List<Coupon> findByCompanyAndCategory(Company company, Category category);

 @Query(
 nativeQuery = true,
 value = "select * from coupons where company_id=?1 and price<?2"
 )
 List<Coupon> findByCompanyAndMaxPrice(int companyId, double maxPrice);
 *
 */