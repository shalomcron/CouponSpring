package com.coupon.CouponSpring.controllers;

import com.coupon.CouponSpring.bean.Company;
import com.coupon.CouponSpring.bean.Coupon;
import com.coupon.CouponSpring.bean.Customer;
import com.coupon.CouponSpring.services.clients.*;
import com.coupon.CouponSpring.services.login.ClientType;
import com.coupon.CouponSpring.services.login.LoginException;
import com.coupon.CouponSpring.services.login.LoginManager;
import com.coupon.CouponSpring.session.CouponSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/companies")
public class CompanyController {
    @Autowired
    CouponSession couponSession;
    @Autowired
    private LoginManager loginManager;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.CREATED)
    public Company logIn(@RequestParam String email, @RequestParam String password) throws LoginException {
        CompanyService companyService = (CompanyService) loginManager
                .login(email, password, ClientType.Company);
        Company company = companyService.getCompanyDetails();
        couponSession.setCompanySession(company.getId(), companyService);
        return company;
    }

//    @GetMapping("/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public Customer getCustomerDetails(@PathVariable int id) throws CustomerException {
//        return couponSession.getCustomer(id).getCustomerDetails();
//    }
//
//    @GetMapping("{id}/coupons")
//    @ResponseStatus(HttpStatus.OK)
//    public List<Coupon> getPurchaseCoupon(@PathVariable int id) throws CustomerException {
//        return couponSession.getCustomer(id).getPurchasedCoupons();
//    }
//
//    @GetMapping("{id}/coupons/category")
//    @ResponseStatus(HttpStatus.OK)
//    public List<Coupon> getPurchaseCouponByCategory(@PathVariable int id, @RequestParam String category) throws CustomerException {
//        return couponSession.getCustomer(id).getPurchasedCategoryCoupons(category);
//    }
//
//    @GetMapping("{id}/coupons/maxPrice")
//    @ResponseStatus(HttpStatus.OK)
//    public List<Coupon> getPurchasedMaxPriceCoupons(@PathVariable int id, @RequestParam double price) throws CustomerException {
//        return couponSession.getCustomer(id).getPurchasedMaxPriceCoupons(price);
//    }
//
//    @PostMapping("{customerId}/coupons/{couponId}")
//    @ResponseStatus(HttpStatus.CREATED)
//    public String purchaseCoupon(@PathVariable int customerId, @PathVariable int couponId)
//            throws CustomerException, CouponPurchaseException, CouponException {
//        couponSession.getCustomer(customerId).purchaseCoupon(couponId);
//        return "OK";
//    }


}


