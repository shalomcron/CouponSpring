package com.coupon.CouponSpring.repos;

import com.coupon.CouponSpring.bean.Company;
import com.coupon.CouponSpring.bean.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

    Optional<Company> findByEmailAndPassword(String email, String password);

    boolean existsByEmail(String name);

    boolean existsByEmailAndPassword(String email, String password);

    boolean existsByName(String name);

}

/**



 *
 */