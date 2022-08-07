package com.coupon.CouponSpring.services.clients;

import com.coupon.CouponSpring.bean.Coupon;
import com.coupon.CouponSpring.bean.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    boolean login(String email, String password);

    void purchaseCoupon(int couponId) throws CouponException, CustomerException, CouponPurchaseException;

    Customer getCustomerDetails();

    List<Coupon> getPurchasedCoupons();

    List<Coupon> getPurchasedCategoryCoupons(String category);

    List<Coupon> getPurchasedMaxPriceCoupons(double price);
}
