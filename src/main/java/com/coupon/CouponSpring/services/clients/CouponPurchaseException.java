package com.coupon.CouponSpring.services.clients;

public class CouponPurchaseException extends Exception {
    public CouponPurchaseException(CouponPurchaseMsg purcahasMsg, String trigger)
    {
        super(purcahasMsg.getMsg() + "-" + trigger);
    }
}
