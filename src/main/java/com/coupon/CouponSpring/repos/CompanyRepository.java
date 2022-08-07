package com.coupon.CouponSpring.repos;
import com.coupon.CouponSpring.bean.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

    Optional<Company> findByEmailAndPassword(String email, String password);

    boolean existsByEmail(String name);

    boolean existsByName(String name);

}
