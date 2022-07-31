package com.coupon.CouponSpring.repos;

import com.coupon.CouponSpring.bean.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    boolean existsByEmailAndPassword(String email, String password);

    boolean existsByEmail(String email);

    Optional<Customer> findByEmailAndPassword(String email, String password);

    @Modifying
    @Transactional
    @Query(
            value = "INSERT INTO `coupons-using-spring`.`customer_coupons` (`customer_id`, `coupon_id`) VALUES (?1, ?2)",
            nativeQuery = true
    )
    void purchaseCoupon(int customerId, int couponId);
}
