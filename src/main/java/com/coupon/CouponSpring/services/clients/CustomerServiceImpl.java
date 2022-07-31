package com.coupon.CouponSpring.services.clients;

import com.coupon.CouponSpring.bean.Coupon;
import com.coupon.CouponSpring.bean.Customer;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CustomerServiceImpl extends ClientService implements CustomerService {

    Customer customer;

    @Override
    public boolean login(String email, String password) {
        try {
            this.customer = customerRepository.findByEmailAndPassword(email, password)
                    .orElseThrow();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public void purchaseCoupon(int couponId) throws CouponException {
        // TODO: checks !!
        Coupon coupon = couponRepository.findById(couponId).orElseThrow(() ->
                new CouponException(CouponMsg.COUPON_ID_NO_EXISTS, String.valueOf(couponId))
        );
        customerRepository.purchaseCoupon(this.customer.getId(), couponId);
    }

    @Override
    public Customer getCustomerDetails() {
        return customerRepository.findById(customer.getId()).orElseThrow();
    }
}
