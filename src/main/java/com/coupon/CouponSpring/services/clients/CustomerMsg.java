package com.coupon.CouponSpring.services.clients;

public enum CustomerMsg {
    CUSTOMER_EMAIL_ALLREADY_EXIST("cannot add customer with exist email"),
    CUSTOMER_ID_CANNOT_BE_UPDATED("cannot update customer id"),
    CUSTOMER_ID_NOT_EXIST("cannot get customer that not exist"),
    CUSTOMER_IS_SESSION_NOT_FOUND("customer session is not found");

    public String getMsg() {
        return msg;
    }

    private final String msg;

    CustomerMsg(String msg) {
        this.msg = msg;
    }
}
