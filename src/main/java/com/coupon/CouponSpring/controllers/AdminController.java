package com.coupon.CouponSpring.controllers;

import com.coupon.CouponSpring.bean.Company;
import com.coupon.CouponSpring.services.clients.AdminService;
import com.coupon.CouponSpring.services.clients.CompanyException;
import com.coupon.CouponSpring.services.login.ClientType;
import com.coupon.CouponSpring.services.login.LoginException;
import com.coupon.CouponSpring.services.login.LoginManager;
import com.coupon.CouponSpring.session.ClientsSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/admin")
public class AdminController {
    private final String adminServiceKey = "adminService";
    @Autowired
    ClientsSession clientsSession;
    @Autowired
    private LoginManager loginManager;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.CREATED)
    public String logIn(@RequestParam String email, @RequestParam String password) throws LoginException {
        AdminService adminService = (AdminService) loginManager
                .login(email, password, ClientType.Admin);
        clientsSession.setAdminSession(adminServiceKey, adminService);
        return "Admin logged in ok";
    }

    @DeleteMapping("/deleteCompany/{companyId}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteCompany(@PathVariable int companyId) throws Exception {
        clientsSession.getAdminSession(adminServiceKey).deleteCompany(companyId);
        return "Company " + companyId + " deleted";
    }

    @DeleteMapping("/deleteCustomer/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteCustomer(@PathVariable int customerId) throws Exception {
        clientsSession.getAdminSession(adminServiceKey).deleteCustomer(customerId);
        return "Customer " + customerId + " deleted";
    }


}


