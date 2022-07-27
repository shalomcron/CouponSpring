package com.coupon.CouponSpring.services.clients;

public class CouponException extends Exception {
    public CouponException(CouponMsg companyMsg, String trigger) {
        super(companyMsg.getMsg() + "-" + trigger);
    }

}
