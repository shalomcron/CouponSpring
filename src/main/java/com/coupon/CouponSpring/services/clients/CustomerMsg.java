package com.coupon.CouponSpring.services.clients;

public enum CustomerMsg {
    CUSTOMER_EMAIL_EXIST("cannot add customer with exist email"),
    CUSTOMER_ID_CANNOT_BE_UPDATED("cannot update customer id");

    public String getMsg() {
        return msg;
    }

    private final String msg;

    CustomerMsg(String msg) {
        this.msg = msg;
    }
}
