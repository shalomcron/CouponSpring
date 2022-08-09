package com.coupon.CouponSpring.controllers;

import com.coupon.CouponSpring.bean.Company;
import com.coupon.CouponSpring.services.clients.*;
import com.coupon.CouponSpring.services.login.ClientType;
import com.coupon.CouponSpring.services.login.LoginException;
import com.coupon.CouponSpring.services.login.LoginManager;
import com.coupon.CouponSpring.session.ClientsSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/companies")
public class CompanyController {
    @Autowired
    ClientsSession clientsSession;
    @Autowired
    private LoginManager loginManager;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.CREATED)
    public Company logIn(@RequestParam String email, @RequestParam String password) throws LoginException {
        CompanyService companyService = (CompanyService) loginManager
                .login(email, password, ClientType.Company);
        Company company = companyService.getCompanyDetails();
        clientsSession.setCompanySession(company.getId(), companyService);
        return company;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Company getCompanyDetails(@PathVariable int id) throws CompanyException {
        return clientsSession.getCompanySession(id).getCompanyDetails();
    }

    @DeleteMapping("/{companyId}/delete/{couponId}")
    @ResponseStatus(HttpStatus.OK)
    public String companyDeleteCoupon(@PathVariable int companyId, @PathVariable int couponId) throws CompanyException {
        clientsSession.getCompanySession(companyId).deleteCoupon(couponId);
        return "Coupon " + couponId + " deleted";
    }

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


