package com.coupon.CouponSpring.clr;

import com.coupon.CouponSpring.bean.Category;
import com.coupon.CouponSpring.bean.Coupon;
import com.coupon.CouponSpring.services.clients.CompanyService;
import com.coupon.CouponSpring.services.clients.CustomerService;
import com.coupon.CouponSpring.services.login.ClientType;
import com.coupon.CouponSpring.services.login.LoginManager;
import com.coupon.CouponSpring.utils.BeanFactoryUtils;
import com.coupon.CouponSpring.utils.Print;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class Test03CustomerServiceTest implements CommandLineRunner {
    private CustomerService customer1 = null;
    private CustomerService customer2 = null;

    @Autowired
    private LoginManager loginManager;

    @Override
    public void run(String... args) {
        Print.printMainCaption("\n Start Customer Service Test");
        loginTests1();
        loginTests2();
        Print.printMainCaption("Start purchase Coupons Test");
        purchaseCouponsTest(customer1);
        purchaseCouponsTest(customer2);
    }

    private void purchaseCouponsTest(CustomerService customer) {
        try {
            String name = customer.getCustomerDetails().getFirsName();
            customer.purchaseCoupon(1);
            Print.printSubCaption(name + " purchased coupon successfully, couponId:" + 1);
            customer.purchaseCoupon(2);
            Print.printSubCaption(name + " purchased coupon successfully, couponId:" + 2);
            customer.purchaseCoupon(3);
            Print.printSubCaption(name + " purchased coupon successfully, couponId:" + 3);
        } catch (Exception e) {
            Print.printException("fail to purchase coupon", e);
        }
    }


    private void loginTests1() {
        try {
            customer1 = (CustomerService) loginManager
                    .login("Customer-1-mail@gmail.com", "Customer-1-password", ClientType.Customer);
            Print.printSubCaption("customer 1 logged in successfully");
            System.out.println("customer1:" + customer1);
        } catch (Exception e) {
            Print.printException("company customer 1 fail to log-in", e);
        }
    }

    private void loginTests2() {
        try {
            customer2 = (CustomerService) loginManager
                    .login("Customer-2-mail@gmail.com", "Customer-2-password", ClientType.Customer);
            Print.printSubCaption("customer 2 logged in successfully");
            System.out.println("customer2:" + customer2);
        } catch (Exception e) {
            Print.printException("company customer 2 fail to log-in", e);
        }
    }

}


