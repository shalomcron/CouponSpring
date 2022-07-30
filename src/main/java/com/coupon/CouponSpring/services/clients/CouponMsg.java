package com.coupon.CouponSpring.services.clients;

public enum CouponMsg {
    COUPON_ID_NO_EXISTS("coupon id not exists"),
    COUPON_TITLE_EXIST_SAME_COMPANY("cannot add coupon with exist name for same company"),
    COUPON_ID_CANNOT_BE_CHANGED("cannot update coupon id"),
    COUPON_COMPANY_ID_CANNOT_BE_CHANGED("cannot update coupon company id");
    public String getMsg() {
        return msg;
    }

    private final String msg;

    CouponMsg(String msg) {
        this.msg = msg;
    }
}
