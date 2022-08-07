package com.coupon.CouponSpring.repos;
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

    @Query(
            value = "SELECT IF(end_date > CURDATE(), 0, 1) FROM `coupons-using-spring`.`coupons` where (`id` = ?1)",
            nativeQuery = true
    )
    int isExpired(int id);

    @Query(
            value = "SELECT * " +
                    "FROM `coupons-using-spring`.coupons AS c \n" +
                    "INNER JOIN `coupons-using-spring`.customers_vs_coupons AS cvc \n" +
                    "ON c.id = cvc.coupon_id AND cvc.customer_id = ?1",
            nativeQuery = true
    )
    List<Coupon> findPurchasedCoupons(int customerId);
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