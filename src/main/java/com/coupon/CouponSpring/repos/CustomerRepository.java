package com.coupon.CouponSpring.repos;

import com.coupon.CouponSpring.bean.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    boolean existsByEmailAndPassword(String email, String password);
    boolean existsByEmail(String email);
}
