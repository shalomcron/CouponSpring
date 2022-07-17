package com.coupon.CouponSpring.clr;

import com.coupon.CouponSpring.utils.Print;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class CompanyReposTest implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        Print.printCaption("company repos test");

        Print.printSubCaption("company repos test");

    }
}
