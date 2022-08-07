package com.coupon.CouponSpring.repos;

import com.coupon.CouponSpring.bean.Coupon;
import com.coupon.CouponSpring.bean.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

 Optional<Customer> findByEmailAndPassword(String email, String password);

 boolean existsByEmail(String email);
// c.id, c.amount, c.category,c.description,c.end_date,c.image,c.start_date,c.title
 @Query(
         value = "SELECT * " +
                 "FROM `coupons-using-spring`.coupons AS c \n" +
                 "INNER JOIN `coupons-using-spring`.customers_vs_coupons AS cvc \n" +
                 "ON c.id = cvc.coupon_id AND cvc.customer_id = ?1",
         nativeQuery = true
 )
 List<Coupon> findPurchasedCoupons(int customerId);
}

