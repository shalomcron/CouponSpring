package com.coupon.CouponSpring.clr.on.services;

import com.coupon.CouponSpring.bean.Category;
import com.coupon.CouponSpring.bean.Company;
import com.coupon.CouponSpring.bean.Coupon;
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
public class Test03CompanyServiceTest implements CommandLineRunner {
    CompanyService companyService = null;

    @Autowired
    private LoginManager loginManager;

    @Override
    public void run(String... args) {
        Print.printMainCaption("Start company test");
        Print.printMainCaption("Start company login Tests");
        loginTests();
        Print.printMainCaption("Start add Coupons Test");
        addCouponsTest();
        Print.printMainCaption("Start add Coupons Same Title SameCompany Test");
        addCouponsSameTitleSameCompanyTest();
        Print.printMainCaption("Start update Coupon Test");
        updateExistsCouponTest(1);
        updateExistsCouponTest(2);
        updateExistsCouponIdTest(1, 777);
        updateExistsCouponCompanyTest(1, 555);
        Print.printMainCaption("Start delete Coupon Test");
        deleteCouponTest(1);
        Print.printMainCaption("Start get All Coupons Test");
        getAllCouponsTest();
    }

    private void getAllCouponsTest() {
        companyService.getAllCoupons();
    }

    private void deleteCouponTest(int couponId) {
        try {
            companyService.deleteCoupon(couponId);
            Print.printSubCaption("successfully delete coupon company with id : " + couponId);
        } catch (Exception e) {
            Print.printException("fail in update Coupon", e);
        }
    }

    private void updateExistsCouponCompanyTest(int couponId, int changedCompanyId) {
        try {
            Coupon coupon = companyService.getSingleCoupon(couponId);
            coupon.getCompany().setId(changedCompanyId);
            companyService.updateCoupon(couponId, coupon);
            Print.printSubCaption("successfully update coupon with title : " + coupon.getTitle());
        } catch (Exception e) {
            Print.printException("fail in update Coupon", e);
        }
    }

    private void updateExistsCouponIdTest(int couponId, int changedCouponId) {
        try {
            Coupon coupon = companyService.getSingleCoupon(couponId);
            coupon.setId(changedCouponId);
            companyService.updateCoupon(couponId, coupon);
            Print.printSubCaption("successfully update coupon with title : " + coupon.getTitle());
        } catch (Exception e) {
            Print.printException("fail in update Coupon", e);
        }
    }

    private void updateExistsCouponTest(int couponId) {
        try {
            Coupon coupon = companyService.getSingleCoupon(couponId);
            coupon.setTitle("CHANGED TITLE - " + couponId);
            companyService.updateCoupon(couponId, coupon);
            Print.printSubCaption("successfully update coupon with title : " + coupon.getTitle());
        } catch (Exception e) {
            Print.printException("fail in update Coupon", e);
        }
    }

    private void addCouponsTest() {
        addCouponTest("Coupon food", 140, Category.Food, 12);
        addCouponTest("Coupon Electricity", 70, Category.Electricity, 12);
        addCouponTest("Coupon Restaurant", 35, Category.Restaurant, 12);
    }

    private void addCouponTest(String title, int amount, Category category, int endMoth) {
        try {
            Coupon coupon = BeanFactoryUtils.getCoupon(title, amount, category, endMoth);
            companyService.addCoupon(coupon);
            Print.printSubCaption("successfully add coupon with title : " + coupon.getTitle());
        } catch (Exception e) {
            Print.printException("fail in add Coupon", e);
        }
    }

    private void addCouponsSameTitleSameCompanyTest() {
        Print.printSubCaption("trying to add coupon same title same company");
        addCouponTest("Coupon Restaurant", 35, Category.Restaurant, 12);
    }

    private void loginTests() {
        try {
            Print.printSubCaption("trying to log-in company");
            companyService = (CompanyService) loginManager.login("bla", "bla", ClientType.Company);
        } catch (Exception e) {
            Print.printException("fail to log-in", e);
        }
        try {
            companyService = (CompanyService) loginManager.login("TARA-mail@gmail.com", "TARA-password", ClientType.Company);
            Print.printSubCaption("log-in company successfully");
        } catch (Exception e) {
            Print.printException("fail to log-in", e);
        }
    }
}


