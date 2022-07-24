package com.coupon.CouponSpring.clr.on.repos;

import com.coupon.CouponSpring.bean.Category;
import com.coupon.CouponSpring.bean.Company;
import com.coupon.CouponSpring.bean.Coupon;
import com.coupon.CouponSpring.bean.Customer;
import com.coupon.CouponSpring.repos.CouponRepository;
import com.coupon.CouponSpring.repos.CustomerRepository;
import com.coupon.CouponSpring.utils.BeanFactoryUtils;
import com.coupon.CouponSpring.utils.Print;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

// @Component
@Order(2)
public class CustomerReposTest implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CouponRepository couponRepository;

    @Override
    public void run(String... args) {
        Print.printSubCaption("Start customer repos test");

        Print.printSubCaption("add customer");
        // roni
        String roniName = "roni";
        Customer roni = BeanFactoryUtils.getCustomer(roniName);
        Coupon roniCoupon1 = couponRepository.findById(1).orElseThrow();
        Coupon roniCoupon2 = couponRepository.findById(2).orElseThrow();
        Coupon roniCoupon3 = couponRepository.findById(3).orElseThrow();
        roni.setCoupons(Arrays.asList(roniCoupon1, roniCoupon2, roniCoupon3));

        // yuval
        String yuvalName = "Yuval";
        Customer yuval = BeanFactoryUtils.getCustomer(yuvalName);
        Coupon yuvalCoupon1 = couponRepository.findById(4).orElseThrow();
        Coupon yuvalCoupon2 = couponRepository.findById(5).orElseThrow();
        Coupon yuvalCoupon3 = couponRepository.findById(6).orElseThrow();
        yuval.setCoupons(Arrays.asList(yuvalCoupon1, yuvalCoupon2, yuvalCoupon3));
        // save
        customerRepository.saveAll(Arrays.asList(roni, yuval));
        Print.printSubCaption("print all customers");
        customerRepository.findAll().forEach(System.out::println);
        Print.printSubCaption("END customer repos test");
    }
}
