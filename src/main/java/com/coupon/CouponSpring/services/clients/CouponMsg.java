package com.coupon.CouponSpring.services.clients;

public enum CouponMsg {
    COUPON_TITLE_EXIST_SAME_COMPANY("cannot add coupon with exist name for same company"),
    COUPON_ID_CANNOT_BE_CHANGED("cannot update coupon id");
    public String getMsg() {
        return msg;
    }

    private final String msg;

    CouponMsg(String msg) {
        this.msg = msg;
    }
}
