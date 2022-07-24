package com.coupon.CouponSpring.services.clients;

public class CompanyException extends Exception {
    public CompanyException(CompanyMsg companyMsg, String trigger) {
        super(companyMsg.getMsg() + "-" + trigger);
    }
}
