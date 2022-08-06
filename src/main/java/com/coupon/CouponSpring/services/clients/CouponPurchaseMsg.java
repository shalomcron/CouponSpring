package com.coupon.CouponSpring.services.clients;

public enum CouponPurchaseMsg {
    COUPON_WAS_PURCHASED_BY_USER("coupon was already purchased by user"),
    COUPON_AMOUNT_IS_ZERO("coupon amount is 0");

    public String getMsg() {
        return msg;
    }

    private final String msg;

    CouponPurchaseMsg(String msg) {
        this.msg = msg;
    }
}
