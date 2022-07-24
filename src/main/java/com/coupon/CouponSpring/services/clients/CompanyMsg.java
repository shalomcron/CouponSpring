package com.coupon.CouponSpring.services.clients;

public enum CompanyMsg {
    COMPANY_NOT_EXIST("company not exist on DB"),
    COMPANY_NAME_ALREADY_EXIST("cannot add company with exist name"),
    COMPANY_EMAIL_ALREADY_EXIST("cannot add company with exist email"),
    COMPANY_ID_CANNOT_BE_UPDATED("company id cannot be updated"),
    COMPANY_NAME_CANNOT_BE_UPDATED("company name cannot be updated");

    private final String msg;

    CompanyMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
