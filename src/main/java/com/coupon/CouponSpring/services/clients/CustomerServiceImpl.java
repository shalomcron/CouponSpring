package com.coupon.CouponSpring.services.clients;

import com.coupon.CouponSpring.bean.Coupon;
import com.coupon.CouponSpring.bean.Customer;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Set;

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
        customer.getCoupons().add(coupon);
        // customer.setCoupons(Arrays.asList(coupon));
        //  customer.setCoupons(Set.of(coupon));
        // customerRepository.save(customer);
        customerRepository.purchaseCoupon(this.customer.getId(), couponId);
    }

    @Override
    public Customer getCustomerDetails() {
        return customerRepository.findById(customer.getId()).orElseThrow();
    }
}
