package com.coupon.CouponSpring.utils;


import com.coupon.CouponSpring.bean.Category;
import com.coupon.CouponSpring.bean.Company;
import com.coupon.CouponSpring.bean.Coupon;

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

    public static Coupon getCoupon2() {
        return Coupon.builder()
                // .companyId(1)
                .description("des2")
                .title("title2")
                .amount(2)
                .category(Category.Electricity)
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plus(1, ChronoUnit.MONTHS)))
                .build();
    }
}
