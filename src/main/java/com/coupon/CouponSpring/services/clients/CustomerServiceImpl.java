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
        Coupon coupon = couponRepository.findById(couponId).orElseThrow(() ->
                new CouponException(CouponMsg.COUPON_ID_NO_EXISTS, String.valueOf(couponId))
        );
        Customer customerUpdate = getCustomerDetails();
        customerUpdate.getCoupons().add(coupon);
        coupon.getCustomers().add(customerUpdate);
        customerRepository.save(customerUpdate);
        // customerRepository.purchaseCoupon(this.customer.getId(), couponId);
        // customerRepository.
    }

    @Override
    public Customer getCustomerDetails() {
        return customerRepository.findById(customer.getId()).orElseThrow();
    }
}
