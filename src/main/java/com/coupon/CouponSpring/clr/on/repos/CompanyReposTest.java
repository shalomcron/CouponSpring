package com.coupon.CouponSpring.clr.on.repos;

import com.coupon.CouponSpring.bean.Category;
import com.coupon.CouponSpring.bean.Company;
import com.coupon.CouponSpring.bean.Coupon;
import com.coupon.CouponSpring.repos.CompanyRepository;
import com.coupon.CouponSpring.utils.BeanFactoryUtils;
import com.coupon.CouponSpring.utils.Print;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

// @Component
@Order(1)
public class CompanyReposTest implements CommandLineRunner {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public void run(String... args) {
        Print.printSubCaption("Start company repos test");

        Print.printSubCaption("add companies");
        // fox
        String foxCompanyName = "FOX";
        Company foxCompany = BeanFactoryUtils.getCompany(foxCompanyName);
        Coupon foxCoupon1 = BeanFactoryUtils.getCoupon(foxCompany, 1, 1, Category.Electricity, 1);
        Coupon foxCoupon2 = BeanFactoryUtils.getCoupon(foxCompany, 2, 2, Category.Food, 2);
        foxCompany.setCoupons(Arrays.asList(foxCoupon1, foxCoupon2));

        // tnuva
        String tnuvaCompanyName = "TNUVA";
        Company tnuvaCompany = BeanFactoryUtils.getCompany(tnuvaCompanyName);
        Coupon tnuvaCoupon1 = BeanFactoryUtils.getCoupon(tnuvaCompany, 1, 1, Category.Electricity, 1);
        Coupon tnuvaCoupon2 = BeanFactoryUtils.getCoupon(tnuvaCompany, 2, 2, Category.Food, 2);
        tnuvaCompany.setCoupons(Arrays.asList(tnuvaCoupon1, tnuvaCoupon2));

        // tara
        String taraCompanyName = "TARA";
        Company taraCompany = BeanFactoryUtils.getCompany(taraCompanyName);
        Coupon taraCoupon1 = BeanFactoryUtils.getCoupon(taraCompany, 1, 1, Category.Electricity, 1);
        Coupon taraCoupon2 = BeanFactoryUtils.getCoupon(taraCompany, 2, 2, Category.Food, 2);
        taraCompany.setCoupons(Arrays.asList(taraCoupon1, taraCoupon2));

        companyRepository.saveAll(Arrays.asList(foxCompany, tnuvaCompany, taraCompany));

        Print.printSubCaption("print all companies");
        companyRepository.findAll().forEach(System.out::println);

        Print.printSubCaption("End company repos test");
    }
}
