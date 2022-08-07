package com.coupon.CouponSpring.repos;

import com.coupon.CouponSpring.bean.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

 Optional<Customer> findByEmailAndPassword(String email, String password);

 boolean existsByEmail(String email);

}

