package com.coupon.CouponSpring.services.clients;

public enum CompanyMsg {
    COMPANY_NOT_EXIST("company not exist on DB"),
    COMPANY_NAME_ALREADY_EXIST("cannot add company with exist name"),
    COMPANY_EMAIL_ALREADY_EXIST("cannot add company with exist email"),
    COMPANY_ID_CANNOT_BE_UPDATED("cannot update company id"),
    COMPANY_NAME_CANNOT_BE_UPDATED("cannot update company name");

    private final String msg;

    CompanyMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
