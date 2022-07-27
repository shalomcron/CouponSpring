package com.coupon.CouponSpring.utils;


import com.coupon.CouponSpring.bean.Category;
import com.coupon.CouponSpring.bean.Company;
import com.coupon.CouponSpring.bean.Coupon;
import com.coupon.CouponSpring.bean.Customer;

import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class BeanFactoryUtils {

    public static Company getCompany(String name) {
        return Company
                .builder()
                .name(name)
                .email(name + "-" + "mail@gmail.com")
                .password(name + "-" + "password")
                .build();
    }


    public static Coupon getCoupon(Company company, int amount, int index, Category category, int endMoth) {
        return Coupon.builder()
                .company(company)
                .description(company.getName() + "-" + "desc" + "-" + index)
                .title(company.getName() + "-" + "title" + "-" + index)
                .amount(amount)
                .category(category)
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plus(endMoth, ChronoUnit.MONTHS)))
                .build();
    }
    public static Coupon getCoupon(String title, int amount, Category category, int endMoth) {
        return Coupon.builder()
                .description(title + "-" + "desc")
                .title(title + "-" + "title")
                .amount(amount)
                .category(category)
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plus(endMoth, ChronoUnit.MONTHS)))
                .build();
    }


    public static Customer getCustomer(String name) {
        return Customer.builder()
                .firsName(name)
                .lastName(name)
                .email(name + "-" + "mail@gmail.com")
                .password(name + "-" + "password")
                .build();
    }
}
