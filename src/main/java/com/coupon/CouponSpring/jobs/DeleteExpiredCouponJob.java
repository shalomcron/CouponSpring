package com.coupon.CouponSpring.jobs;

import com.coupon.CouponSpring.repos.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DeleteExpiredCouponJob {
    @Autowired
    private CouponRepository couponRepository;

    // @Scheduled(fixedRate = 24 * 60 * 60 * 1000)
    @Scheduled(fixedRate = 10000)
    public void deleteExpiredCoupons() {
        System.out.println("deleteExpiredCoupon !!!");
        couponRepository.deleteExpiredCoupons();
        System.out.println("deleteExpiredCoupon OK !!!");
    }
}
