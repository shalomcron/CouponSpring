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
    CompanyService companyTaraService = null;
    CompanyService companyFoxService = null;

    @Autowired
    private LoginManager loginManager;

    @Override
    public void run(String... args) {
        Print.printMainCaption("Start company test");
        Print.printMainCaption("Start company login Tara Tests");
        loginTaraTests();
        Print.printMainCaption("Start company login Fox Tests");

        loginFoxTests();
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
        Print.printMainCaption("Start get All Coupons Test");
        getAllCouponsTest();
        Print.printMainCaption("Start get All Category Coupons Test");
        getAllCategoryCouponsTest(Category.Vacation);
        Print.printMainCaption("Start get All MaxPrice Coupons Test");
        getAllMaxPriceCouponsTest(55);
    }

    private void getAllMaxPriceCouponsTest(double maxPrice) {
        try {
            Company company = companyTaraService.getCompanyDetails();
            Print.printSubCaption("print all companies maxPrice:" + company.getId() + "-" + maxPrice);
            companyTaraService.getAllCoupons(maxPrice).forEach(System.out::println);
        } catch (Exception e) {
            Print.printException("fail in getAllCoupons maxPrice", e);
        }
    }

    private void getAllCategoryCouponsTest(Category category) {
        Company company = companyTaraService.getCompanyDetails();
        Print.printSubCaption("print all companies for category:" + company.getId() + "-" + category.name());
        companyTaraService.getAllCoupons(category).forEach(System.out::println);
    }

    private void getAllCouponsTest() {
        Company company = companyTaraService.getCompanyDetails();
        Print.printSubCaption("print all companies for comppany:" + company.getId() + "-" + company.getName());
        companyTaraService.getAllCoupons().forEach(System.out::println);
    }

    private void updateExistsCouponCompanyTest(int couponId, int changedCompanyId) {
        try {
            Coupon coupon = companyTaraService.getSingleCoupon(couponId);
            coupon.getCompany().setId(changedCompanyId);
            companyTaraService.updateCoupon(couponId, coupon);
            Print.printSubCaption("successfully update coupon with title : " + coupon.getTitle());
        } catch (Exception e) {
            Print.printException("fail in update Coupon", e);
        }
    }

    private void updateExistsCouponIdTest(int couponId, int changedCouponId) {
        try {
            Coupon coupon = companyTaraService.getSingleCoupon(couponId);
            coupon.setId(changedCouponId);
            companyTaraService.updateCoupon(couponId, coupon);
            Print.printSubCaption("successfully update coupon with title : " + coupon.getTitle());
        } catch (Exception e) {
            Print.printException("fail in update Coupon", e);
        }
    }

    private void updateExistsCouponTest(int couponId) {
        try {
            Coupon coupon = companyTaraService.getSingleCoupon(couponId);
            coupon.setTitle("CHANGED TITLE - " + couponId);
            companyTaraService.updateCoupon(couponId, coupon);
            Print.printSubCaption("successfully update coupon with title : " + coupon.getTitle());
        } catch (Exception e) {
            Print.printException("fail in update Coupon", e);
        }
    }

    private void addCouponsTest() {
        addTaraCouponTest("TARA food", 140, Category.Food, 1);
        addTaraCouponTest("TARA Electricity", 70, Category.Electricity, 2);
        addTaraCouponTest("TARA Restaurant", 35, Category.Restaurant, 3);
        addTaraCouponTest("TARA Vacation 1", 15, Category.Vacation, 4);
        addTaraCouponTest("TARA Vacation 2", 7, Category.Vacation, 5);
        // FOX
        addFoxCouponTest("FOX food", 7, Category.Vacation, 5);
        addFoxCouponTest("FOX Electricity", 70, Category.Electricity, 2);
    }

    private void addTaraCouponTest(String title, int amount, Category category, int endMoth) {
        try {
            Coupon coupon = BeanFactoryUtils.getCoupon(title, amount, category, endMoth);
            companyTaraService.addCoupon(coupon);
            Print.printSubCaption("successfully add coupon with title : " + coupon.getTitle());
        } catch (Exception e) {
            Print.printException("fail in add Coupon", e);
        }
    }

    private void addFoxCouponTest(String title, int amount, Category category, int endMoth) {
        try {
            Coupon coupon = BeanFactoryUtils.getCoupon(title, amount, category, endMoth);
            companyFoxService.addCoupon(coupon);
            Print.printSubCaption("successfully add coupon with title : " + coupon.getTitle());
        } catch (Exception e) {
            Print.printException("fail in add Coupon", e);
        }
    }

    private void addCouponsSameTitleSameCompanyTest() {
        Print.printSubCaption("trying to add coupon same title same company");
        addTaraCouponTest("TARA Restaurant", 35, Category.Restaurant, 12);
    }

    private void loginTaraTests() {
        try {
            Print.printSubCaption("trying to log-in company");
            companyTaraService = (CompanyService) loginManager
                    .login("bla", "bla", ClientType.Company);
        } catch (Exception e) {
            Print.printException("fail to log-in", e);
        }
        try {
            companyTaraService = (CompanyService) loginManager
                    .login("TARA-mail@gmail.com", "TARA-password", ClientType.Company);
            Print.printSubCaption("log-in TARA company successfully");
        } catch (Exception e) {
            Print.printException("fail to log-in", e);
        }
    }
    private void loginFoxTests() {
        try {
            companyFoxService = (CompanyService) loginManager
                    .login("FOX-mail@gmail.com", "FOX-password", ClientType.Company);
            Print.printSubCaption("log-in FOX company successfully");
        } catch (Exception e) {
            Print.printException("fail to log-in", e);
        }
    }
}


