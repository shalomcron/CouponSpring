package com.coupon.CouponSpring.services.clients;

import com.coupon.CouponSpring.bean.Coupon;
import com.coupon.CouponSpring.bean.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl extends ClientService implements CustomerService {

    Customer customer;

    @Override
    public boolean login(String email, String password) {
        try {
            this.customer = customerRepository.findByEmailAndPassword(email, password)
                    .orElseThrow();
            return true;
        } catch (Exception e) {
            System.out.println("Ex IN customer login:" + e.getMessage());
            return false;
        }

    }

    @Override
    public void purchaseCoupon(int couponId) throws CouponException {
        Coupon coupon = couponRepository.findById(couponId).orElseThrow(() ->
                new CouponException(CouponMsg.COUPON_ID_NO_EXISTS, String.valueOf(couponId))
        );
        System.out.println("**^^" + coupon);
        // TODO: SINGULAR??
        customer.getCoupons().add(coupon);
        customerRepository.save(customer);
    }
}
