package com.coupon.CouponSpring.clr;

import com.coupon.CouponSpring.bean.Category;
import com.coupon.CouponSpring.bean.Company;
import com.coupon.CouponSpring.bean.Coupon;
import com.coupon.CouponSpring.services.clients.AdminService;
import com.coupon.CouponSpring.services.clients.CompanyException;
import com.coupon.CouponSpring.services.clients.CompanyService;
import com.coupon.CouponSpring.services.login.ClientType;
import com.coupon.CouponSpring.services.login.LoginManager;
import com.coupon.CouponSpring.utils.BeanFactoryUtils;
import com.coupon.CouponSpring.utils.Print;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class Test02CompanyServiceTest implements CommandLineRunner {
    private CompanyService companyTeva = null;
    private CompanyService companyFox = null;

    @Autowired
    private LoginManager loginManager;

    @Override
    public void run(String... args) {
        Print.printMainCaption("Start Company Service Test");
        loginTests();
        Print.printMainCaption("Start add Teva Coupons ");
        addTevaCouponsTest();
    }

    private void addTevaCouponsTest() {
        try {
            Coupon coupon1 = BeanFactoryUtils.getCoupon("Teva 1", 1, 111.45, Category.Vacation, 1);
            companyTeva.addCoupon(coupon1);
            Print.printSubCaption("successfully add coupon with title : " + coupon1.getTitle());
            Coupon coupon2 = BeanFactoryUtils.getCoupon("Teva 2", 2, 222.45, Category.Vacation, 1);
            companyTeva.addCoupon(coupon2);
            Print.printSubCaption("successfully add coupon with title : " + coupon2.getTitle());
            Coupon coupon3 = BeanFactoryUtils.getCoupon("Teva 3", 3, 333.45, Category.Vacation, 1);
            companyTeva.addCoupon(coupon3);
            Print.printSubCaption("successfully add coupon with title : " + coupon3.getTitle());
        } catch (Exception e) {
            Print.printException("Teva fail in add Coupon", e);
        }

    }

    private void loginTests() {
        try {
            companyTeva = (CompanyService) loginManager
                    .login("TEVA-mail@gmail.com", "TEVA-password", ClientType.Company);
            Print.printSubCaption("companyTeva logged in successfully");
        } catch (Exception e) {
            Print.printException("company Teva fail to log-in", e);
        }
        try {
            companyFox = (CompanyService) loginManager
                    .login("FOX-mail@gmail.com", "FOX-password", ClientType.Company);
            Print.printSubCaption("companyFox logged in successfully");
        } catch (Exception e) {
            Print.printException("company Fox fail to log-in", e);
        }
    }

}


