package com.coupon.CouponSpring.repos;

import com.coupon.CouponSpring.bean.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

 Optional<Customer> findByEmailAndPassword(String email, String password);

 boolean existsByEmail(String email);

}

