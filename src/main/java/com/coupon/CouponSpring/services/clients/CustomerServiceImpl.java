package com.coupon.CouponSpring.services.clients;

import com.coupon.CouponSpring.bean.Coupon;
import com.coupon.CouponSpring.bean.Customer;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Objects;

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
    public void purchaseCoupon(int couponId) throws CouponException, CouponPurchaseException {
        Coupon coupon = couponRepository.findById(couponId).orElseThrow(() ->
                new CouponException(CouponMsg.COUPON_ID_NO_EXISTS, String.valueOf(couponId))
        );
        Customer customerToUpdate = getCustomerDetails();

        if (customerToUpdate.getCoupons().contains(coupon)) {
            throw new CouponPurchaseException(CouponPurchaseMsg.COUPON_WAS_PURCHASED_BY_USER,
                    customerToUpdate.getId() + "(" + coupon.getId() + "-" + coupon.getTitle() + ")");
        }

        if (coupon.getAmount() == 0) {
            throw new CouponPurchaseException(CouponPurchaseMsg.COUPON_AMOUNT_IS_ZERO,
                    customerToUpdate.getId() + "(" + coupon.getId() + "-" + coupon.getTitle() + ")");
        }


        if (couponRepository.isExpired(coupon.getId()) == 1) {
            throw new CouponPurchaseException(CouponPurchaseMsg.COUPON_IS_EXPIRED,
                    customerToUpdate.getId() + "(" + coupon.getId() + "-" + coupon.getEndDate() + ")");
        }

        customerToUpdate.getCoupons().add(coupon);
        coupon.getCustomers().add(customerToUpdate);
        customerRepository.save(customerToUpdate);
        couponRepository.decreaseAmount(couponId);
    }

    @Override
    public Customer getCustomerDetails() {
        return customerRepository.findById(customer.getId()).orElseThrow();
    }
}
