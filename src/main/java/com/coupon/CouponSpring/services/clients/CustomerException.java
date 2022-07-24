package com.coupon.CouponSpring.services.clients;

public class CustomerException extends Exception {
    public CustomerException(CustomerMsg customerMsg, String trigger) {
        super(customerMsg.getMsg() + "-" + trigger);
    }
}
